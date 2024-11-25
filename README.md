# Learn Maven
## 1. Introduction
* [ ] what is maven
* [ ] what does a maven project look like <br>
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
```
[source](https://maven.apache.org/guides/getting-started/)
- [ ] where do dependencies come from
- [ ] where do dependencies get saved to

## 2. Project Requirements
- [ ] I need a project I can build CSV files on the fly.
- [ ] I want it to be made for the command line.
- [ ] I want to be able to specify column names until I give an empty line.
- [ ] I want to be able to specify the type of data for each column.
- [ ] I want to specify how many rows to be created.
- [ ] I want a csv to be created with randomized data.

## 3. Project Notes
<details>
<summary>Repository</summary

[MDH Repo](https://nexus.health.state.mn.us/)

```
<repositories>
    <repository>
        <id>central</id>
        <url>https://nexus.health.state.mn.us/repository/public/</url>
    </repository>
</repositories>

<pluginRepositories>
    <pluginRepository>
        <id>central</id>
        <url>https://nexus.health.state.mn.us/repository/public/</url>
    </pluginRepository>
</pluginRepositories>
```
</details>

<details>
<summary>Dependency</summary>

[Scopes](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Dependency_Scope)

</details>

<details>
<summary>Build</summary>

[Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

Default Lifecycle:
`validate > compile > test > package > verify > install > deploy`

</details>

## 4. Spring Boot Project
