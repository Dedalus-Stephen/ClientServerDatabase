package am.romanbalayan.ClientServerDatabase.Utility.LoadExistingUsers;

/*
public class FTPUploadDemo {
    public static void main(String[] args) {
        String server = "";
        int port = 21;
        String user = "";
        String pass = "";

        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

            File localFile = new File("");

            String remoteFile = "/public_html/userLoginPage.html";
            InputStream inputStream = new FileInputStream(localFile);

            boolean hasSucceed = ftpClient.storeFile(remoteFile, inputStream);
            inputStream.close();
            if (hasSucceed) {
                System.out.println("File is uploaded successfully.");
            }
        } catch (Exception e){
            System.out.println("Exception occurred while uploading file.");
            e.printStackTrace();
        }
    }
}
*/

