import io.netty.handler.codec.http.HttpRequest;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.filters.ResponseFilter;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;
import io.netty.handler.codec.http.HttpResponse;

public class BrowserMob {
    static BrowserMobProxyServer proxyServer;
    public static void StartProxy(){
        proxyServer = new BrowserMobProxyServer();
        proxyServer.start(8888);
        proxyServer.addRequestFilter(new RequestFilter() {
            @Override
            public HttpResponse filterRequest(HttpRequest httpRequest, HttpMessageContents httpMessageContents, HttpMessageInfo httpMessageInfo) {
                System.out.println("URL:" + httpMessageInfo.getOriginalUrl());
                System.out.println("REQUEST CONTENT:" + httpMessageContents.getTextContents());
                return null;
            }
        });
        proxyServer.addResponseFilter(new ResponseFilter() {
            @Override
            public void filterResponse(HttpResponse httpResponse, HttpMessageContents httpMessageContents, HttpMessageInfo httpMessageInfo) {
                System.out.println("RESPONSE STATUAS:" + httpResponse.getStatus());
                System.out.println("RESPONSE CONTENT:" + httpMessageContents.getTextContents());
            }
        });
    }

    public static void StopProxy(){
        proxyServer.stop();
    }
}
