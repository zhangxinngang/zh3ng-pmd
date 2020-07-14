package com.zh3ng.club.pmd.custom;

import com.zh3ng.club.pmd.custom.version.VersionManager;
import net.sourceforge.pmd.PMD;

/**
 * @author zhangxingang
 * @created on 2020/5/3
 *
 */
public class Main {
    public static void main(String[] args) {
        showSlogon();
        showVersion();
        PMD.main(args);
    }

    private static void showSlogon(){
        System.out.println(
                        "\n" +
                        " _______           ______   _        _______        _______  ______   _______ \n" +
                        "/ ___   )|\\     /|/ ___  \\ ( (    /|(  ____ \\      (  ____ )/ ___  \\ (  ____ \\\n" +
                        "\\/   )  || )   ( |\\/   \\  \\|  \\  ( || (    \\/      | (    )|\\/   \\  \\| (    \\/\n" +
                        "    /   )| (___) |   ___) /|   \\ | || |      _____ | (____)|   ___) /| |      \n" +
                        "   /   / |  ___  |  (___ ( | (\\ \\) || | ____(_____)|  _____)  (___ ( | |      \n" +
                        "  /   /  | (   ) |      ) \\| | \\   || | \\_  )      | (            ) \\| |      \n" +
                        " /   (_/\\| )   ( |/\\___/  /| )  \\  || (___) |      | )      /\\___/  /| (____/\\\n" +
                        "(_______/|/     \\|\\______/ |/    )_)(_______)      |/       \\______/ (_______/\n" +
                        "                                                                           "

        );
    }

    private static void showVersion(){
        VersionManager versionManager = new VersionManager();

        String version = versionManager.getVersion();

        System.out.println("version:"+version);
    }
}
