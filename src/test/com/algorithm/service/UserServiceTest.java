//package com.algorithm.service;
//
//import User;
//import UserDao;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import javax.management.OperationsException;
//
//import static org.junit.Assert.*;
//
//public class UserServiceTest {
//    private UserService service;
//    @Before
//    public void setup(){
//        service = new UserService(new UserDao());
//    }
//
//
//
//
//    @Mock
//    private UserDao userDao;
//
//    @Test
//    public void testQueryWithMock(){
//        MockitoAnnotations.initMocks(userDao);
//
//        UserService service = new UserService(userDao);
//        Mockito.when(userDao.getCount()).thenReturn(10);
//        int cout = service.queryUsercount();
//        assertEquals(10,cout );
////        try {
////            int cout = service.queryUsercount();
////            fail("should not process ");
////            //assertEquals(0,cout );
////        }catch ( Exception e ){
////            assertTrue(e instanceof UnsupportedOperationException);
////        }
//
//    }
//
//
//
//
////
////    @Test
////    public void testQuery(){
////        try {
////            int cout = service.queryUsercount();
////            fail("should not process ");
////            //assertEquals(0,cout );
////        }catch ( Exception e ){
////            assertTrue(e instanceof UnsupportedOperationException);
////        }
////
////    }
////
////    @Test
////    public void testSave(){
////        //service.save(new User());
////        try {
////            int cout = service.save(new User());
////            fail("should not process ");
////            //assertEquals(0,cout );
////        }catch ( Exception e ){
////            assertTrue(e instanceof UnsupportedOperationException);
////        }
////    }
//}