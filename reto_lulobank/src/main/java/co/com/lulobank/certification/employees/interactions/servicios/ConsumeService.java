package co.com.lulobank.certification.employees.interactions.servicios;

public final class ConsumeService {

  private ConsumeService() {}

  public static ConsumeServicePostSimple postSimple(String resource, Object request) {
    return new ConsumeServicePostSimple(resource, request);
  }

  public static ConsumeServiceGetAll getAll(String resource) {
    return new ConsumeServiceGetAll(resource);
  }

  public static ConsumeServiceGetById getById(String resource, String id) {
    return new ConsumeServiceGetById(resource, id);
  }

  public static ConsumeServiceDeleteById deleteById(String resource, String id) {
    return new ConsumeServiceDeleteById(resource, id);
  }
}
