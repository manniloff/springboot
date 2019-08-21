package com.example.sweater.controller;


import com.example.sweater.domen.Message;
import com.example.sweater.repos.MessageRepo;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    @InjectMocks
    MainController sut;
    @Mock
    private MessageRepo messageRepo;

    @Test
    public void main() {
        //prepare "using mackito"
        when(messageRepo.findAll()).thenReturn(ImmutableList.of());
        //testing
       Iterable<Message>  messages = messageRepo.findAll();
       //validate
        verify(messageRepo).findAll();
    }
}