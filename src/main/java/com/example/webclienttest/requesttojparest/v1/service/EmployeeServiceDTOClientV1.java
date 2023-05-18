package com.example.webclienttest.requesttojparest.v1.service;


import com.example.webclienttest.requesttojparest.v1.dto.EmployeeDTOV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmployeeServiceDTOClientV1 {

    @Value("${findAll}")
    private String employeeAll;
    @Value("${findByNickname}")
    private String employeeByNickname;
    @Value("${create}")
    private String employeeCreate;
    @Value("${update}")
    private String employeeUpdate;
    @Value("${delete}")
    private String employeeDelete;

    private final WebClient webClient;

    @Autowired
    public EmployeeServiceDTOClientV1(WebClient webClient) {
        this.webClient = webClient;
    }


    public List<EmployeeDTOV1> findAll() {
        return webClient.get()
                .uri(employeeAll)
                .retrieve()
                .bodyToFlux(EmployeeDTOV1.class)
                .collectList()
                .block();
    }

    public EmployeeDTOV1 findByNickname(String nickname) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(employeeByNickname)
                        .queryParam("nickname", nickname)
                        .build())
                .retrieve()
                .bodyToMono(EmployeeDTOV1.class)
                .block();
    }

    public EmployeeDTOV1 create(EmployeeDTOV1 newEmployeeDTOV1) {
        return webClient.post()
                .uri(employeeCreate)
                .bodyValue(newEmployeeDTOV1)
                .retrieve()
                .bodyToMono(EmployeeDTOV1.class)
                .block();
    }

    public EmployeeDTOV1 update(EmployeeDTOV1 updatedEmployeeDTOV1) {
        return webClient.put()
                .uri(employeeUpdate)
                .bodyValue(updatedEmployeeDTOV1)
                .retrieve()
                .bodyToMono(EmployeeDTOV1.class)
                .block();
    }

    // TODO ПОСМОТРЕТЬ!!!!!
//    public void delete(String nickname) {
//        webClient.method(HttpMethod.DELETE)
//                .uri(uriBuilder -> uriBuilder
//                        .path(employeeDelete)
//                        .queryParam("nickname", nickname)
//                        .build())
//                .bodyValue()
//                .retrieve()
//                .bodyToMono(Void.class)
//                .block();
//    }

    public void delete(String nickname) {
        webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .path(employeeDelete)
                        .queryParam("nickname", nickname)
                        .build())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

//    public void delete(String nickname) {
//        webClient.delete()
//                .uri("/delete/?nickname={nickname}", nickname)
//                .retrieve()
//                .bodyToMono(Void.class)
//                .block();
//    }



//    public void delete(EmployeeDTOV1 deletedEmployeeDTOV1) {
//        return webClient.delete()
//                .uri("/delete", deletedEmployeeDTOV1.getNickname())
////                .bodyValue(deletedEmployeeDTOV1)
//                .retrieve()
//                .bodyToMono(EmployeeDTOV1.class)
//                .block();
//    }

//    public EmployeeDTOV1 delete(EmployeeDTOV1 deletedEmployeeDTOV1) {
//        return webClient.delete()
//                .uri(uriBuilder -> uriBuilder
//                .path("/delete")
//                        .("nickname", deletedEmployeeDTOV1.getNickname())
//                .build())
//                .retrieve()
//                .bodyToMono(EmployeeDTOV1.class)
//                .block();
//    }



//    HttpClient httpClient = HttpClient.newHttpClient(); // Создание экземпляра HttpClient
//
//    HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create("http://localhost:8081/api/v1/employee")) // Установка URI запроса
//            .build();
//
//
//    public String findAll() {
//        try {
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println("Response Body: " + response.body());
//            return response.body();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
