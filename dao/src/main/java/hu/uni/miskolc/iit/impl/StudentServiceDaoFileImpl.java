package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;
import hu.uni.miskolc.iit.model.StudentRequestComplain;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StudentServiceDaoFileImpl implements StudentServiceDao {

    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    @Override
    public List<Form> findAllForms() {
        return null;
    }

    @Override
    public String checkRequestStatus(int requestid) throws RequestDoesNotExistException {
        List<Request> requests = readAllRequests();

        for (Request r : requests) {
            if(r.getRequestID() == requestid)
            {
                return r.getRequestStatus();
            }
        }

        throw new RequestDoesNotExistException();
    }

    private List<Request> readAllRequests() {
        List<Request> requests = new ArrayList<>();
        Document document;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{

            InputStream is = new FileInputStream("testDB.xml");
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(is);
            NodeList nodeList = document.getElementsByTagName("request");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                String[] requestStrings = new String[8];

                requestStrings[0] = element.getElementsByTagName("requestID").item(0).getTextContent();
                requestStrings[1] = element.getElementsByTagName("studentID").item(0).getTextContent();
                requestStrings[2] = element.getElementsByTagName("requestDate").item(0).getTextContent();
                requestStrings[3] = element.getElementsByTagName("teacherID").item(0).getTextContent();
                requestStrings[4] = element.getElementsByTagName("requestStatus").item(0).getTextContent();
                requestStrings[5] = element.getElementsByTagName("description").item(0).getTextContent();
                requestStrings[6] = element.getElementsByTagName("courseID").item(0).getTextContent();
                requestStrings[7] = element.getElementsByTagName("formID").item(0).getTextContent();

                LocalDate localDate = LocalDate.parse(requestStrings[2], formatter);
                Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                Request request1 = new Request(Integer.parseInt(requestStrings[0]),
                        Integer.parseInt(requestStrings[1]),
                        date,
                        Integer.parseInt(requestStrings[3]),
                        requestStrings[4],
                        requestStrings[5],
                        Integer.parseInt(requestStrings[6]),
                        Integer.parseInt(requestStrings[7])
                );

                requests.add(request1);
            }

            return requests;
        }catch (IOException e) {
            e.printStackTrace();
        }catch(ParserConfigurationException pce) {
            //LOGGER.trace("parsing error ", pce);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return requests;
    }

    @Override
    public void createComplain(int requestID, String complain) throws RequestDoesNotExistException {
        List<StudentRequestComplain> complaints = readAllComplaints();
        List<Request> requests = readAllRequests();

        boolean v = false;

        if (complain == null || complain.isEmpty()) throw new IllegalArgumentException();

        for(Request r : requests) {

            if (r.getRequestID() == requestID){
                v = true;
                break;
            }

        }
        if(!v) {
            throw new RequestDoesNotExistException();
        }

        int maxId = 0;
        for(StudentRequestComplain complaint : complaints) {
            if(maxId < complaint.getId())
            {
                maxId = complaint.getId();
            }
        }

        StudentRequestComplain complaint = new StudentRequestComplain(requestID, complain, maxId + 1);

        writeComplaint(complaint);
    }

    private List<StudentRequestComplain> readAllComplaints() {
        List<StudentRequestComplain> complaints = new ArrayList<>();
        Document document;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            InputStream is = new FileInputStream("testDB.xml");
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(is);
            NodeList nodeList = document.getElementsByTagName("complaint");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                String[] complaintStrings = new String[3];

                complaintStrings[0] = element.getElementsByTagName("requestID").item(0).getTextContent();
                complaintStrings[1] = element.getElementsByTagName("complaintText").item(0).getTextContent();
                complaintStrings[2] = element.getElementsByTagName("ID").item(0).getTextContent();

                StudentRequestComplain complaint1 = new StudentRequestComplain(Integer.parseInt(complaintStrings[0]),
                        complaintStrings[1],
                        Integer.parseInt(complaintStrings[2]));

                complaints.add(complaint1);
            }
            return complaints;
        }catch(ParserConfigurationException pce) {
            //LOGGER.trace("parsing error ", pce);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return complaints;
    }

    private void writeComplaint(StudentRequestComplain complaint) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document;
        try {
            InputStream is = new FileInputStream("testDB.xml");
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(is);
            NodeList nodeList = document.getElementsByTagName("complaints");

            if(nodeList.getLength() == 0 || nodeList.getLength() > 1)
            {
                //throw new ;
            }

            Element root = (Element)nodeList.item(0);

            Element complaintElem = document.createElement("complaint");

            Element idElem = document.createElement("ID");
            idElem.appendChild(document.createTextNode(Integer.toString(complaint.getId())));
            complaintElem.appendChild(idElem);

            Element complaintTextElem = document.createElement("complaintText");
            complaintTextElem.appendChild(document.createTextNode(complaint.getComplain()));
            complaintElem.appendChild(complaintTextElem);

            Element requestIdElem = document.createElement("requestID");
            requestIdElem.appendChild(document.createTextNode(Integer.toString(complaint.getRequestId())));
            complaintElem.appendChild(requestIdElem);

            root.appendChild(complaintElem);

            is.close();

            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-2");
            tr.setOutputProperty("{http://xml.apache.org/xslt} indent-amount", "4");
            FileOutputStream fos = new FileOutputStream("testDB.xml");
            tr.transform(new DOMSource(document), new StreamResult(fos));
            fos.close();


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
