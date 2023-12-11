package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.checkerframework.checker.optional.qual.Present;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReusableMethods {

    public static String getScreenshot() throws IOException {

        String date = formatCurrentDate("yyyyMMddhhmmss");

        File source = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

        String name="2023";

        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";

        File targetFile = new File(target);

        FileUtils.copyFile(source, targetFile);

        return  target;

    }


    public static void emailSender() {
        try {
            Date date=new Date();
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            String formatliZaman = dateFormat.format(date);
            System.out.println("Şu anki tarih ve saat: " + formatliZaman);


            // E-posta nesnesini oluşturma
            HtmlEmail email = new HtmlEmail();


            email.setFrom("gfbarann@gmail.com");

            // E-posta sunucusunun ayarları
            email.setHostName("smtp.gmail.com"); // E-posta sağlayıcınıza göre değiştirin
            email.setSmtpPort(587); // SMTP portu
            email.setAuthenticator(new DefaultAuthenticator("gfbarann@gmail.com", "iwct nfma jlfa ktjl")); // Gmail uygulama şifresi
            email.setStartTLSRequired(true);

            // Alıcı e-posta adresi
           email.addTo("gfbarann@gmail.com","Alıcı1");
         // email.addTo("baran.business@outlook.com","Alıcı2");

            // E-posta başlığı
            email.setSubject("Cucumber HTML Raporu");

            // HTML raporu dosyası

            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath("/Users/team/IdeaProjects/waa2_web/target/cucumberReportsUI.html");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Cucumber HTML Raporu");
            attachment.setName(formatliZaman+" cucumber-reportsUI.html");


            // E-posta içeriği
            email.setHtmlMsg("Cucumber raporu ve hataya ait screenshot ekte bulunmaktadir.Iyi calismalar");

            // Ek dosyayı e-postaya ekleme
            email.attach(attachment);


            // E-postayı gönderme
            email.send();

            System.out.println("E-posta başarıyla gönderildi.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String formatCurrentDate(String pattern){

        return new SimpleDateFormat(pattern).format(new Date());

    }


    public static String[] filterCountriesForHomes(){
        String[] readCountry = {"aucar", "auhome", "arcar", "arhome", "brcar", "brhome", "becar", "behome", "cacar", "cahome", "cocar", "cohome", "clcar", "clhome", "decar", "dehome", "escar", "eshome", "frcar", "frhome", "huhome", "hucar", "idhome", "idcar", "inhome", "incar", "ircar", "irhome", "itcar", "ithome", "kzcar", "kzhome", "mxcar", "mxhome", "myhome", "mycar", "nlcar", "nlhome", "phhome", "phcar", "pkcar", "pkhome", "plcar", "plhome", "rocar", "rohome", "ptcar", "pthome", "uacar", "uahome", "ukcar", "ukhome", "homes", "cars", "zacar", "zahome", "dkcar", "dkhome", "secar", "sehome", "nohome", "nocar"};

        // car içeren öğeleri silmek için yeni bir liste oluşturma
        List<String> filteredList = new ArrayList<>();

        for (String item : readCountry) {
            if (!item.contains("car")) {
                filteredList.add(item);
            }
        }

        // Listeyi diziye dönüştürme
        String[] resultArray = filteredList.toArray(new String[0]);


        return resultArray;
    }

    public static int findElementInList(String key){
        List<WebElement> listOfPropertyType=DriverManager.getDriver().findElements(By.xpath("//*[@id='property_type_list']//a[contains(@href,'/')]"));
        List<WebElement> listOfCity=DriverManager.getDriver().findElements(By.xpath("//*[@id='location_list']//a[contains(@href,'/')]"));

        String expectedValue = key.toLowerCase(); // Aranlılan metin
        int index = -1;

        for (int i = 0; i < listOfPropertyType.size(); i++) {
            String actualValue = listOfPropertyType.get(i).getText().toLowerCase();
            if (actualValue.equals(expectedValue)) {
                index = i;
                System.out.println("İstenilen metin bulundu: " + expectedValue + " Index değeri: " + index);
                break;
            }
        }

        if (index == -1) {
            for (int i = 0; i < listOfCity.size(); i++) {
                String actualValue = listOfCity.get(i).getText().toLowerCase();
                if (actualValue.equals(expectedValue)) {
                    index = i;
                    System.out.println("İstenilen metin bulundu: " + expectedValue + " Index değeri: " + index);
                    break;
                }
            }
        }
        return index;
    }

    public static int convertStringToInt(WebElement key){

        int result=Integer.parseInt(key.getText().replaceAll("[^0-9]", ""));

        return result;
    }

    public static String extractIllegalChar(WebElement key){
        String result=key.getText().toLowerCase().replaceAll("[^a-zA-Z]", "");
        return result;
    }


    public static void sendEmailWithReport(String failedTestCase) {
        // E-posta gönderme işlemi için gerekli ayarları yap
        final String username = "gfbarann@gmail.com";
        final String password = "iwct nfma jlfa ktjl";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Oturum oluştur
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Mesaj oluştur
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("gfbarann@gmail.com"));
            message.setSubject("Test Failure - " + failedTestCase);

            // Rapor dosyasını ekleyerek mail oluştur
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            String filename = "target/cucumber-reportsUI.html";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(new File(filename).getName());
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            // Mail'i gönder
            Transport.send(message);
            System.out.println("Mail gönderildi.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    }


