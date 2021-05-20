package wrappers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {
    public  static  String jsonPath = "E:\\salma\\ITI\\Courses\\API Testing\\Workspace\\Testautomation_Workshop\\Dataset.json";
    JSONObject jsonObject;
    public JsonFileReader(String file)
    {
        parseJson(file);
    }

    public void parseJson(String file)
    {
        String jsonData = readFile(file);
        try {
            jsonObject = new JSONObject(jsonData);
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
    }

    public String readFile(String file)
    {
        String result="";
        try {
            BufferedReader bufferedReader = new BufferedReader( new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String Line = bufferedReader.readLine();

            while (Line!=null)
            {
                stringBuilder.append(Line);
                Line= bufferedReader.readLine();
            }
            result = stringBuilder.toString();
            return result;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getValueOfNode(String parent){

        String [] tree= parent.split("/");
        if(tree.length==1)
        {
            return jsonObject.getString(tree[0]);
        }
        int i = 1;
        JSONObject parentNode= null;
        try
        {
            parentNode = (JSONObject) jsonObject.get(tree[0]);
            while (i < tree.length-1){
                parentNode = (JSONObject)parentNode.get(tree[i]);
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return  null;
        }
        return parentNode.getString(tree[i]);
    }

    public List<String> getValueOf(String parent, String child)
    {
        Object obj=null;
        JSONArray value=null;
        String singleValue=null;
        boolean isArray= false;

        if(child==null)
        {
            try
            {
                obj= jsonObject.get(parent);
                if(obj instanceof JSONArray)
                {
                    value= new JSONArray(jsonObject.getJSONArray(parent).toString());
                    isArray= true;
                }
                else
                {
                    singleValue=jsonObject.getString(parent);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }

        else
        {
            JSONObject parentNode;
            try
            {
                parentNode= (JSONObject) jsonObject.get(parent);
                obj= parentNode.get(child);
                if(obj instanceof JSONArray)
                {
                    value= new JSONArray(parentNode.getJSONArray(child).toString());
                    isArray= true;
                }

                else
                {
                    singleValue=parentNode.getString(child);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }

        List<String> list = new ArrayList<>();
        if(isArray)
        {
            for(int i=0; i< value.length(); i++)
            {
                try
                {
                    list.add(value.getString(i));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        }

        else
        {
            list.add(singleValue);
        }

        return list;
    }
}
