Continuous Delivery using Jenkins (JEE, JBoss, Wildfly)
=========================================================================

# Getting Started

```
mvn clean package
target/wildfly-8.1.0.Final/bin/domain.sh
mvn wildfly:deploy
target/wildfly-8.1.0.Final/bin/jboss-cli.sh -c --command="deploy target/cd-wildfly-1.0.war --all-server-groups"
```

