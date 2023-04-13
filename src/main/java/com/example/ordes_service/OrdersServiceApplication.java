package com.example.ordes_service;



import com.example.ordes_service.variables.LocalVariables;
import com.neovisionaries.i18n.CountryCode;
import org.apache.hc.core5.http.ParseException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class OrdersServiceApplication {


    private final static String accessToken = getAccessToken();
    private final static String trackId = "0eGsygTp906u18L0Oimnem";
    public static void main(String[] args)  {
        System.out.println(Arrays.toString(getTrack("Провела екскурсію").getArtists()));

    }

    public static Track getTrack(String trackName) {

        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(getAccessToken())
                .build();

        try{
            SearchTracksRequest searchRequest = spotifyApi.searchTracks(trackName)
                    .market(CountryCode.US)//  рынок, для которого будет выполнен поиск
                    .limit(1) // ограничение на количество результатов
                    .build();
            Track track = searchRequest.execute().getItems()[0];
            track.getAlbum();
            return track;
        }

        catch (IOException  | ParseException  | SpotifyWebApiException e){
            System.out.println("Error: " + e.getCause().getMessage());
        }
        return null;
    }


    public static String getAccessToken() {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(LocalVariables.CLIENT_ID)
                .setClientSecret(LocalVariables.CLIENT_SECRET)
                .build();

        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
        CompletableFuture<ClientCredentials> authorizationCodeCredentialsFuture = clientCredentialsRequest.executeAsync();

        try {
            ClientCredentials authorizationCodeCredentials = authorizationCodeCredentialsFuture.get();
            return authorizationCodeCredentials.getAccessToken();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        }
        return null;
    }




}
