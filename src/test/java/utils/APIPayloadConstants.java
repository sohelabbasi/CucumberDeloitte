package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"selda\",\n" +
                "  \"emp_lastname\": \"ms\",\n" +
                "  \"emp_middle_name\": \"niche\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2018-09-21\",\n" +
                "  \"emp_status\": \"probation\",\n" +
                "  \"emp_job_title\": \"QA Engineer\"\n" +
                "}";

        return createEmployeePayload;
    }

    public static String createJsonEmployeePayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","selda");
        obj.put("emp_lastname","ms");
        obj.put("emp_middle_name","niche");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","2018-09-21");
        obj.put("emp_status","probation");
        obj.put("emp_job_title","QA Engineer");
        return obj.toString();
    }

    public static String payloadDynamic(String emp_firstname, String emp_lastname, String emp_middlename,
                                        String emp_gender, String emp_birthday, String emp_status,
    String emp_job_title){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middlename);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();

    }


}
