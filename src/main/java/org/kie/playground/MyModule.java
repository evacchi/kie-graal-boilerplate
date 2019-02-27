package org.kie.playground;

import java.util.Collections;
import java.util.List;

import org.drools.model.Index;
import org.drools.model.Model;
import org.drools.model.Rule;
import org.drools.model.Variable;
import org.drools.model.impl.ModelImpl;
import org.drools.modelcompiler.CanonicalKieModuleModel;
import org.kie.api.rules.RuleUnitInstance;
import org.kie.api.runtime.KieSession;

import static org.drools.model.DSL.*;
import static org.drools.model.PatternDSL.*;

public class MyModule implements CanonicalKieModuleModel {

    static MyModule r = new MyModule();

    final Model model;

    MyModule() {
        Variable<Person> markV = declarationOf( Person.class );
        Variable<Person> olderV = declarationOf(Person.class );

        Rule r = rule("beta" )
                .build(
                        pattern(markV)
                                .expr("exprA", p -> p.getName().equals( "Mark" ),
                                      alphaIndexedBy(String.class, Index.ConstraintType.EQUAL, 1, p -> p.getName(), "Mark" ),
                                      reactOn( "name", "age" )),
                        pattern(olderV)
                                .expr("exprB", p -> !p.getName().equals("Mark"),
                                      alphaIndexedBy( String.class, Index.ConstraintType.NOT_EQUAL, 1, p -> p.getName(), "Mark" ),
                                      reactOn( "name" ))
                                .expr("exprC", markV, (p1, p2) -> p1.getAge() > p2.getAge(),
                                      betaIndexedBy( int.class, Index.ConstraintType.GREATER_THAN, 0, p -> p.getAge(), p -> p.getAge() ),
                                      reactOn( "age" )),
                        on(olderV, markV).execute((p1, p2) -> System.out.println ( p1.getName() + " is older than " + p2.getName()))
                );

        model = new ModelImpl().addRule(r);
    }

    RuleUnitInstance<People> peopleRuleUnit(People p) {
        KieSession sess = this.newKieSession();
        return new RuleUnitInstance<>(sess, p);
    }

    @Override
    public String getVersion() {
        return "1";
    }

    @Override
    public List<Model> getModels() {
        return Collections.singletonList(model);
    }

//    public void run() {
//        Person mark = new Person("Mark", 37);
//        Person edson = new Person("Edson", 35);
//        Person mario = new Person("Mario", 40);
//
//        FactHandle markFH = ksession.insert(mark);
//        FactHandle edsonFH = ksession.insert(edson);
//        FactHandle marioFH = ksession.insert(mario);
//
//        ksession.fireAllRules();
//        if (!"Mario is older than Mark".equals( result )) {
//            throw new IllegalStateException();
//        }
//
//        result =( null );
//        ksession.delete( marioFH );
//        ksession.fireAllRules();
//        if (result != null) {
//            throw new IllegalStateException();
//        }
//
//        mark.setAge( 34 );
//        ksession.update( markFH, mark, "age" );
//
//        ksession.fireAllRules();
//        if (!"Edson is older than Mark".equals( result )) {
//            throw new IllegalStateException();
//        }
//
//        System.out.println(result );
//
//        System.out.println("all done");
//
//    }

}
