package com.example.sweater.controller;


import com.example.sweater.domen.Message;
import com.example.sweater.repos.MessageRepo;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    @InjectMocks
    private MessageController messageController;
    @Mock
    private MessageRepo messageRepo;


    @Test
    public void showMessage() {
        //testing
        Iterable<Message> messages = messageRepo.findAll();
        //validate
        verify(messageRepo).findAll();
    }

    @Test
    public void getList(){
        //
        when(messageRepo.findAll()).thenReturn(ImmutableList.of());
        //testing
        Iterable<Message> messages = messageRepo.findAll();
        //validate
        verify(messageRepo).findAll();
    }
}