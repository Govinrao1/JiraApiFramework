package Payloads;

import org.json.JSONObject;

public class ApiIssuesPayloads {
   
	public static JSONObject createPayload() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("fields", new JSONObject()
		        .put("project", new JSONObject().put("key", "MYJ"))
		        .put("summary", "Create issue api is not working")
		        .put("description", "create issue")
		        .put("issuetype", new JSONObject().put("name", "Task")));
		return requestParams;
	}
	public static String updateIssue() {
		JSONObject fields = new JSONObject();
        fields.put("summary", "Login scenario is not working correctly");
        fields.put("description","Login scenario issue update");
        fields.put("assignee", new JSONObject().put("name", "Myself"));

        JSONObject update = new JSONObject();
        update.put("fields", fields);

        return update.toString();
    }
	}
