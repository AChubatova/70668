import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.buildReportTab

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"

project {
    description = "Contains all other projects"

    params {
        param("a", "anew")
    }

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
        }
        feature {
            id = "PROJECT_EXT_2"
            type = "searchBuild"
            param("esHosts", "localhost:9200")
            param("secure:esPassword", "credentialsJSON:bf0192ae-6d79-42ad-90cb-2b8733a66f21")
            param("searchMode", "ELASTIC")
            param("esIndexName", "teamcity-adaec88b-a0b4-4388-b300-b94bf79930192105")
            param("esUsername", "user1new")
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }
}
