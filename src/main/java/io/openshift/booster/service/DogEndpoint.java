/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.openshift.booster.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Path("/fetchDogs")
@Component
public class DogEndpoint {
    @GET
    @Produces("application/json")
    public String fetchDogs() {
        RestTemplate restTemplate = new RestTemplate();
        String result = 
            restTemplate.getForObject("https://dog.ceo/api/breeds/image/random", String.class);
        return result;
    }
}
