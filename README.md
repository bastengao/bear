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

根据 id 查找

    Session session = ...;
    TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

    Bear bear = criteria.equal("id", 1).one();

根据 name 升序排序

    List<Bear> bears = criteria.order("name").list();

根据 age 降序分页

    List<Bear> bears = criteria.orderDESC("age").list(0, 20);

age 大于 5 的 bear 个数

    long count = criteria.gt("age", 5).count();

