package org.gradle;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YAMLReader {

	public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        try {
            RequiredVariables user = mapper.readValue(new File("C:\\Users\\ubhagwat\\Documents\\SKYNET\\Ansible\\tenantdata.yml"), RequiredVariables.class);
            System.out.println(user.getEc2_tag_Name());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
