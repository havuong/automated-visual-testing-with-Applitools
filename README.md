# Automated Visual Testing with [Applitools](https://applitools.com/)
Learn how to effectively add visual validation to existing test automation framework using the Applitools Eyes test automation API. Applitools allows to add eyes to your test automation. The eyes are powered by artificial intelligence and will catch the visual errors just as a human being would.

## What is visual validation
Visual Software Testing is the process of validating the visual aspects of an application's User Interface (UI). In addition to validating that the UI displays the correct content or data, Visual Testing focuses on validating the Layout and Appearance of each visual element of the UI and of the UI as a whole. Layout correctness means that each visual element of the UI is properly positioned on the screen, that it is of the right shape and size, and that it does not overlap or hide other visual elements. Appearance correctness means that the visual elements are of the correct font, color, or image. 

## How to setup your environment to use Applitools Eyes
1. Register for free [Applitools](https://applitools.com/) account
2. Getting the API Key
- Click on the "person" icon in upper right corner
- Click on "My API Key"

## How to add the Applitools Eyes API to your automation framework
1. Create a Maven project and add the following dependencies to the pom.xml
```markdown
<!-- Applitools SDK -->
<dependency>
    <groupId>com.applitools</groupId>
    <artifactId>eyes-selenium-java3</artifactId>
    <version>RELEASE</version>
</dependency>
```
2. Import the SDK
```java
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
```
3. Initialize the SDK
```java
// Initialize the Runner for your test.
EyesRunner runner = new ClassicRunner();

// Initialize the eyes SDK
Eyes eyes = new Eyes(runner);

// Change the APPLITOOLS_API_KEY API key with yours
eyes.setApiKey("APPLITOOLS_API_KEY");
```
4. Start the test (demo)
```java
// Visual checkpoint #1.
driver.get("https://applitools.com/helloworld"); // navigate to website
eyes.checkWindow("Before mouse click");
    
// Visual checkpoint #2
driver.findElement(By.tagName("button")).click(); // Click the button.
eyes.checkWindow("After mouse click"); 
```

## Different levels of image comparison
Applitools Eyes is a very flexible visual validation tool. It recognizes that not all applications are the same and therefore provides various comparison methods so that you have the right level of image matching for your testing. These comparison options are called match levels.

### Exact Match Level
The Exact match level does a pixel by pixel comparison of the images.

```java
eyes.setMatchLevel(MatchLevel.EXACT);
```
### Strict Match Level
The Strict match level is used by default. The Strict method will use AI to compare the images and only detect things that the human eye would.
```java
eyes.setMatchLevel(MatchLevel.STRICT);
```
### Content Match Level
The Content match level is similar to this Strict match level except that it also ignores color differences
```java
eyes.setMatchLevel(MatchLevel.CONTENT);
```
![Content Match Level](https://testautomationu.applitools.com/course5/chapter4-image6.png)
### Layout Match Level
The Layout match level will ignore the content of an application and will only verify the application's structure - that everything is laid out as it should be.
```java
eyes.setMatchLevel(MatchLevel.LAYOUT);
```
![Layout Match Level](https://testautomationu.applitools.com/course5/chapter4-image15.png)
## How to use visual validation for PDF files

### Visually Verifying PDF on the Command Line
- Download the ImageTester.jar file from here: [Download](https://bintray.com/applitoolseyes/generic/download_file?file_path=ImageTester.jar)
- Run command line
```
java -jar ImageTester.jar -k [api-key] -f [path-to-pdf-file]
```

### Visually Verifying PDFs within Code
(see in code)

### Overview of integration with third party
The Applitools Eyes is enabled to integrate with many other programming languages and automation tools.

![Applitools Eyes Web Automation](https://testautomationu.applitools.com/course5/chapter9-image1.png)

![Applitools Eyes Mobile Integration](https://testautomationu.applitools.com/course5/chapter9-image2.png)

![Applitools Eyes for Image and PDF Comparisons](https://testautomationu.applitools.com/course5/chapter9-image3.png)

![Other](https://testautomationu.applitools.com/course5/chapter9-image4.png)
