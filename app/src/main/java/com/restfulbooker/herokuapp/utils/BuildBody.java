package com.restfulbooker.herokuapp.utils;

import java.io.IOException;
import java.util.Map;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.restfulbooker.herokuapp.exeptions.GenerateException;

public class BuildBody {

    private String templateRoute;
    private static final Logger logger = Logger.getLogger("com.library.books");

    public BuildBody(String templateRoute) {
        this.templateRoute = templateRoute;
    }

    public static BuildBody withTemplate(String template) {
        return new BuildBody(template);
    }

    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private String parseJson(String route) {
        String result = "";
        try {
            result = readFileAsString(route);
        } catch (Exception e) {
            logger.log(Level.SEVERE, GenerateException.JSON_TEMPLATE_READ_ERROR, e);
        }
        return result;
    }

    public String withValueNew(Map<String, Object> values) {
        String newTemplate = parseJson(templateRoute);

        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String placeholder = "${" + entry.getKey() + "}";
            Object val = entry.getValue();

            if (val instanceof Number || val instanceof Boolean) {
                newTemplate = newTemplate.replace(placeholder, val.toString());
            } else {
                String strVal = val.toString();
                if (strVal.trim().startsWith("{") || strVal.trim().startsWith("[")) {
                    newTemplate = newTemplate.replace("\"" + placeholder + "\"", strVal);
                } else {
                    String quotedPlaceholder = "\"" + placeholder + "\"";
                    if (newTemplate.contains(quotedPlaceholder)) {
                        newTemplate = newTemplate.replace(quotedPlaceholder, "\"" + strVal + "\"");
                    } else {
                        newTemplate = newTemplate.replace(placeholder, "\"" + strVal + "\"");
                    }
                }
            }
        }
        return newTemplate;
    }

}
