package webserver.controller;

import webserver.request.HttpRequest;
import webserver.response.HttpResponse;

import java.io.FileNotFoundException;

public class MainController extends AbstractController {

    @Override
    protected void doGet(HttpRequest httpRequest, HttpResponse httpResponse) throws FileNotFoundException {
        byte[] staticFile = getStaticFile(httpRequest);
        httpResponse.addStatusLine(httpRequest, "200", "OK");
        httpResponse.addHeader(HEADER_FIELD_CONTENT_TYPE, CONTENT_TYPE_HTML);
        httpResponse.addHeader(HEADER_FIELD_CONTENT_LENGTH, String.valueOf(staticFile.length));
        httpResponse.addBody(staticFile);
    }
}
