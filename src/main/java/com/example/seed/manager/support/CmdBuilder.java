package com.example.seed.manager.support;

import com.google.common.base.Joiner;
import lombok.Builder;

/**
 * 命令常量
 *
 * @author Fururur
 * @date 2020/3/30-16:23
 */
@Builder
public class CmdBuilder {

    /**
     * 统计当前路径下文件个数
     *
     * @param path
     * @return
     */
    public static String countFiles(String path) {
        return Joiner.on(" ").join("ls", "\"" + path + "\"" + "/", "-l |grep \"^-\"|wc -l");
    }

    public static String countDirs(String path) {
        return Joiner.on(" ").join("ls", "\"" + path + "\"" + "/", "-l |grep \"^d\"|wc -l");
    }

    /**
     * mv
     *
     * @param from
     * @param to
     * @return
     */
    public static String mv(String from, String to) {
        return Joiner.on(" ").join("mv", from, to);
    }

    /**
     * rm
     *
     * @param flag
     * @param path
     * @return
     */
    public static String rm(String flag, String path) {
        return Joiner.on(" ").join("rm", flag, path);
    }

    /**
     * 递归创建文件夹
     *
     * @param path
     * @return
     */
    public static String mkdir(String flag, String path) {
        return Joiner.on(" ").join("mkdir", flag, path);
    }

    /**
     * 配置 dir 权限
     *
     * @param flag       flag 可选 -R
     * @param permission 权限 777 755 750
     * @param path       路径
     * @return
     */
    public static String chmod(String flag, String permission, String path) {
        return Joiner.on(" ").join("chmod", flag, permission, path);
    }

    /**
     * systemctl
     *
     * @param flag       flag 可选 -R
     * @param permission 权限 777 755 750
     * @param path       路径
     * @return
     */
    public static String systemctl(String command, String service) {
        return Joiner.on(" ").join("systemctl", command, service);
    }

    /**
     * 查看当前路径下的磁盘空间
     *
     * @param path
     * @return
     */
    public static String df(String path) {
        return Joiner.on(" ").join("df -h", path);
    }

    /**
     * 创建软链接
     *
     * @param src
     * @param dest
     * @return
     */
    public static String ln(String src, String dest) {
        return Joiner.on(" ").join("ln -s", src, dest);
    }

    public static String host(String ip, Integer port) {
        return Joiner.on(":").join(ip, port);
    }

    /**
     * mysql 备份
     *
     * @param user user
     * @param pwd  password
     * @param host host
     * @param port port
     * @param db   db name
     * @param path save path
     * @return
     */
    public static String mysqldump(String user, String pwd, String host, Integer port, String db, String path) {
        return String.format("mysqldump -u%s -p%s -h%s -P%d %s -r %s", user, pwd, host, port, db, path);
    }
    public static String mysqldumpWin(String user, String pwd, String host, Integer port, String db, String path) {
        return String.format("mysqldump.exe -u%s -p%s -h%s -P%d %s -r %s", user, pwd, host, port, db, path);
    }
}
