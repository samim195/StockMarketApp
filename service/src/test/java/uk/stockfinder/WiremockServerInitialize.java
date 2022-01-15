package uk.stockfinder;


import com.github.tomakehurst.wiremock.WireMockServer;

public class WiremockServerInitialize {
    private WireMockServer wireMockServer = new WireMockServer();

    public void startWireMockServer() {
        wireMockServer.start();
    }

    public void stopWireMockServer() {
        wireMockServer.stop();
    }


}
