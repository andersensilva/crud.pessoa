package com.crud.pessoa.event.listener;

import com.crud.pessoa.event.Event;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class Listener implements ApplicationListener<Event> {

    @Override
    public void onApplicationEvent(Event event) {
        HttpServletResponse response = event.getResponse();
        Long id = event.getId();

        adicionarHeaderLocation(response, id);
    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
