package dto;

import lombok.Data;
import org.dwiveddi.utils.csv.annotation.CsvMapped;
import templateengine.FreemarkerTemplateEngine;

import java.util.Map;

/**
 * Created by dwiveddi on 2/6/2018.
 */
@Data
public class RequestResponseCombination {

    private static final FreemarkerTemplateEngine engine = FreemarkerTemplateEngine.getInstance();

    @CsvMapped.Column(index = 0) private String id;
    @CsvMapped.Column(index = 1) private String url;
    @CsvMapped.Column(index = 2) private String method;
    @CsvMapped.NestedColumn(index = {3,4,5}) private Request request;
    @CsvMapped.NestedColumn(index = {6,7,8,9,10,11})private Response response;
    @CsvMapped.Column(index = 12) private String variableName;

    public void format(Map<String, Object> map){
        this.url = engine.generate(this.url, map);
        this.method = engine.generate(this.method, map);
        this.request.format(map);
        this.response.format(map);
    }

    @Override
    public String toString() {
        return "dto.RequestResponseCombination{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", request=" + request +
                ", response=" + response +
                ", variableName='" + variableName + '\'' +
                '}';
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }
}
