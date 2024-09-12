package escuelaing.edu.arep.tools;

public class Response {
    private String contentType;
    private String status;
    private String code;
    private String data;

    public Response(String contentType, String status, String code, String data) {
        this.contentType = contentType;
        this.status = status;
        this.code = code;
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
