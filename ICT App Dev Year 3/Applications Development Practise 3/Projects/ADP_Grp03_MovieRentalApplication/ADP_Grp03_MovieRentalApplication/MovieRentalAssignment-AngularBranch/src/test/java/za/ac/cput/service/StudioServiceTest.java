//package za.ac.cput.service;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.entity.Studio;
//import za.ac.cput.factory.StudioFactory;
//import za.ac.cput.repository.StudioRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//// Author: Marchello Carolus 218234457
//
//class StudioServiceTest {
//
//    private static StudioService service = StudioService.getService();
//    private static Studio studio = StudioFactory.build("12345", "Sony");
//
//
//    @Test
//    void create() {
//        Studio create = service.create(studio);
//        assertEquals(create.getStudioId(), studio.getStudioId());
//        System.out.println("Create: " + create);
//    }
//
//    @Test
//    void read() {
//        Studio read = service.read(studio.getStudioId());
//
//        System.out.println(read);
//
//    }
//
//    @Test
//    void update() {
//        Studio update = new Studio.Builder().copy(studio).setStudioId("2342").build();
//        System.out.println(update);
//
//    }
//
//    @Test
//    void getAll() {
//        System.out.println(service.getAll());
//    }
//
//    @Test
//    void delete() {
//        service.delete(studio.getStudioId());
//
//        System.out.println(studio.getStudioId() + " was deleted.");
//        System.out.println(studio);
//    }
//}
//
