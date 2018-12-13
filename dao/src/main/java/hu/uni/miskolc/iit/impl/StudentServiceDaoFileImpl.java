package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
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
        return null;
    }

    @Override
    public void createComplain(int requestID, String complain) throws ComplainAlreadyExistsException, IllegalArgumentException, RequestDoesNotExistException {

    }
}
