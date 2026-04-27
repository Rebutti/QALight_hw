package java_hw_3;

import java.util.Scanner;

public class DownloadLinkProvider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Write down what program do you want to download, q - quit: ");
            String prog = sc.nextLine();

            if (prog.equals("q")) {
                break;
            }
            System.out.println("Write down what OS do you have, q - quit: ");
            String os = sc.nextLine();
            if (os.equals("q")) {
                break;
            }
            System.out.println("Link: " + linkGiver(prog, os));
        }


    }

    public static String linkGiver(String prog, String os) {
        switch (prog.toLowerCase()) {
            case "intellij idea":
                switch (os.toLowerCase()) {
                    case "linux":
                        return "https://www.jetbrains.com/idea/download/download-thanks.html?platform=linux";
                    case "macos":
                        return "https://www.jetbrains.com/idea/download/download-thanks.html?platform=macM1";
                    case "windows":
                        return "https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows";
                    default:
                        return "Wrote incorrect OS!";

                }
            case "git":
                switch (os.toLowerCase()) {
                    case "linux":
                        return "https://git-scm.com/install/linux";
                    case "macos":
                        return "https://git-scm.com/install/mac";
                    case "windows":
                        return "https://git-scm.com/install/windows";
                    default:
                        return "Wrote incorrect OS!";

                }
            case "java":
                switch (os.toLowerCase()) {
                    case "linux":
                        return "https://javadl.oracle.com/webapps/download/AutoDL?BundleId=252897_0d06828d282343ea81775b28020a7cd3";
                    case "macos":
                        return "https://javadl.oracle.com/webapps/download/AutoDL?BundleId=252900_0d06828d282343ea81775b28020a7cd3";
                    case "windows":
                        return "https://javadl.oracle.com/webapps/download/AutoDL?BundleId=252905_0d06828d282343ea81775b28020a7cd3";
                    default:
                        return "Wrote incorrect OS!";
                }

            default:
                return "Wrote incorrect program!";
        }
    }
}
