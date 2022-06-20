package domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Customer extends User {

   public Customer() {
      this.setAccessLevel(AccessLevel.CUSTOMER); ;
   }




  




}
