package hello.models;


import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Mustafa ULVİ on 10/7/16.
 * <p>
 * A DAO for the entity Book is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 *
 * @author Mustafa ULVİ
 */
@Transactional
public interface BookDao extends CrudRepository<Book, Long> {
}
