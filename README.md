# Bear #

一个基于 Hibernate 向 active record 看齐的小类库

## 用法 ##

Bear 实体

    @Entity
    public class Bear {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String name;
        private int age;
        ...
    }

根据ID查找

    Session session = ...;
    TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

    Bear bear = criteria.where("id", 1).one();

