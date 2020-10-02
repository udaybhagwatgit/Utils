package org.gradle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequiredVariables {

	private String tenant_aws_access_key;
	private String tenant_aws_secret_key;
	private String ec2_vpc_name;
	private String ec2_vpc_cidr_block;
	private String ec2_available_zone;
	private String ec2_security_group_name;
	private String ec2_instance_type;
	private String ec2_tag_Name;
	
}
