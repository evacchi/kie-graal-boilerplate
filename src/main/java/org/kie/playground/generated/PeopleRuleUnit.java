package org.kie.playground.generated;

import org.drools.model.Index;
import org.drools.model.Model;
import org.drools.model.Rule;
import org.drools.model.Variable;
import org.drools.model.consequences.ConsequenceBuilder;
import org.drools.model.impl.ModelImpl;
import org.kie.api.rules.RuleUnit;
import org.kie.playground.People;
import org.kie.playground.Person;

import static org.drools.model.DSL.declarationOf;
import static org.drools.model.DSL.on;
import static org.drools.model.PatternDSL.alphaIndexedBy;
import static org.drools.model.PatternDSL.betaIndexedBy;
import static org.drools.model.PatternDSL.pattern;
import static org.drools.model.PatternDSL.reactOn;
import static org.drools.model.PatternDSL.rule;

public class PeopleRuleUnit extends RuleUnit<People> {

    public PeopleRuleUnit(PeopleModule myModule) {
        super(initModel(myModule));
    }

    private static Model initModel(PeopleModule myModule) {
        Model model;
        Variable<Person> markV = declarationOf(Person.class );
        Variable<Person> olderV = declarationOf(Person.class );

        ConsequenceBuilder._2<Person, Person> execute =
                on(olderV, markV)
                        .execute((p1, p2) -> System.out.println(p1.getName() + " is older than " + p2.getName()));

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
                        execute
                );

        model = new ModelImpl().addRule(r);
        return model;
    }
}
