class SmtpServer {
    void connect() { System.out.println("Connecting to SMTP server..."); }
    void disconnect() { System.out.println("Disconnected from SMTP server."); }
}

class EmailBuilder {
    String build(String to, String subject, String body) {
        return "To: " + to + "\nSubject: " + subject + "\n\n" + body;
    }
}

class EmailSender {
    void send(String message) { System.out.println("Sending email:\n" + message); }
}

class EmailServiceFacade {
    private final SmtpServer smtp = new SmtpServer();
    private final EmailBuilder builder = new EmailBuilder();
    private final EmailSender sender = new EmailSender();

    public void sendEmail(String to, String subject, String body) {
        smtp.connect();
        String message = builder.build(to, subject, body);
        sender.send(message);
        smtp.disconnect();
    }

    public static void main(String[] args) {
        EmailServiceFacade emailService = new EmailServiceFacade();
        emailService.sendEmail("info@djamware.com", "Welcome!", "Thanks for joining Djamware!");
    }
}