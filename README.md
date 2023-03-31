# logs-indentation
Indents the logs according to the parent-child relationship of the methods.


### Usage
```
The project produces 3 JARs:
	logs-indentation-1.0.0
	logs-indentation-1.0.0-exec
	logs-indentation-1.0.0-sources
	
Install the JARs in your repository as follows:
	https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html
	
	
Can be added in project as a Maven dependency:

<dependency>
	<groupId>com.hardcodacii</groupId>
	<artifactId>logs-indentation</artifactId>
	<version>1.0.0</version>
</dependency>

In spring-boot project should be included in spring container as follow:

@Configuration
@ComponentScan("com.hardcodacii.logsindentation.service")
public class ExternalServiceConfig {}
```

### Example (use the demo package that contains a spring-boot demo app)
	[INFO]	enter method Main.start
	[INFO]	enter method Main.start
	[INFO]	method A
	[INFO]	method B
	
		[INFO]	method B
	
		[INFO]	method C
			[INFO]	method A
				[INFO]	method B
			[INFO]	method A
				[INFO]	method B
			[INFO]	method B
		[INFO]	method C
			[INFO]	method B
			[INFO]	method B
			[INFO]	method A
				[INFO]	method B
	
		[INFO]	method D
			[INFO]	method A
				[INFO]	method B
	
			[INFO]	method C
				[INFO]	method A
					[INFO]	method B
				[INFO]	method A
					[INFO]	method B
				[INFO]	method B
			[INFO]	method C
				[INFO]	method B
				[INFO]	method B
				[INFO]	method A
					[INFO]	method B
			[INFO]	method B
	
	[INFO]	exit method Main.start
	[INFO]	exit method Main.start
	[INFO]	exit method DemoPrintApplication.run
