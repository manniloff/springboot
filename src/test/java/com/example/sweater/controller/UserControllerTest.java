package com.example.sweater.controller;

import com.example.sweater.domen.User;
import com.example.sweater.mock.TestMockClass;
import com.example.sweater.repos.UserRepo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private static List<User> users;
    @InjectMocks
    private UserController userController;
    @Mock
    private UserRepo userRepo;
    @InjectMocks
    private TestMockClass testMock;

    @BeforeClass
    public static void setUp() {
        users = Arrays.asList(
                new User("Slava", "123"),
                new User("Oleg", "1"),
                new User("Jenea", "12345")
        );

        users.forEach(System.out::println);
    }

    @Test
    public void userList() {
        Iterable<User> userList = userRepo.findAll();

        assertEquals(3, users.size());
        verify(userRepo).findAll();
    }

    @Test
    public void getUser() {
        User userList = users.get(0);
        String actual = userList.getUsername();
        String expected = "Slava";

        assertEquals(actual, expected);
    }

    @Test
    public void testSomeThing() {
        Comparable c = mock(Comparable.class);

        when(c.compareTo("Test")).thenReturn(1);

        assertEquals(1, c.compareTo("Test"));
    }

    @Test
    public void testMockClass() {
        TestMockClass mockClass = mock(TestMockClass.class);
        TestMockClass mockspy = Mockito.spy(mockClass);

        String actual = "hello world";

        System.out.println(mockspy.helloWorld(actual));

        when(mockClass.helloWorld(actual)).thenReturn("hello world");

        assertEquals(actual, mockClass.helloWorld(actual));
    }

    @Test
    public void testMockClass2() {

        testMock = mock(TestMockClass.class);
        when(testMock.helloWorld2()).thenReturn("hello world");

        String actual = "hello world";
        assertEquals(testMock.helloWorld2(),actual);
    }

}