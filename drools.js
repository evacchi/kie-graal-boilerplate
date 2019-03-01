const ModelImpl = Java.type('org.drools.model.impl.ModelImpl');
const Person = Java.type('org.kie.playground.Person');
const DSL = Java.type('org.drools.model.DSL');
const PatternDSL = Java.type('org.drools.model.PatternDSL');
const On = (v1, v2) => new (Java.type('org.kie.playground.js.Consequence_2'))(v1,v2);
const Index = Java.type('org.drools.model.Index');
const Integer = Java.type('java.lang.Integer');
const RuleRuntime = Java.type('org.kie.api.rules.RuleRuntime');
const markV = DSL.declarationOf( Person.class );
const olderV = DSL.declarationOf( Person.class );

const r = PatternDSL.rule("beta" )
        .build(
                PatternDSL.pattern(markV)
                        .expr("exprA", p => p.getName() ==  "Mark" ,
                              PatternDSL.alphaIndexedBy(String.class, Index.ConstraintType.EQUAL, 1, p => p.getName(), "Mark" ),
                              PatternDSL.reactOn( "name", "age" )),
                PatternDSL.pattern(olderV)
                        .expr("exprB", p => p.getName() != "Mark",
                              PatternDSL.alphaIndexedBy( String.class, Index.ConstraintType.NOT_EQUAL, 1, p => p.getName(), "Mark" ),
                              PatternDSL.reactOn( "name" ))
                        .expr("exprC", markV, (p1, p2) => p1.getAge() > p2.getAge(),
                              PatternDSL.betaIndexedBy( Integer.class, Index.ConstraintType.GREATER_THAN, 0, p => p.getAge(), p => p.getAge() ),
                              PatternDSL.reactOn( "age" )),
                On(olderV, markV)
                .execute((p1, p2) => console.log( p1.getName() + " is older than " + p2.getName()))
        );

const m = new ModelImpl().addRule(r);
const ksession = RuleRuntime.fromModel(m);

console.log("start")

ksession.insert(new Person("Mark", 37));
ksession.insert(new Person("Edson", 35));
ksession.insert(new Person("Mario", 40));

ksession.fireAllRules();

console.log("end")
