package pl.sda.sapiens.ep.repository;

public interface TagRepository {

    boolean saveIfNotPresent(String tag);

}
