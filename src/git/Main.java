package git;


/**
*@author: 杜立茂
*@createDate  : 2018/12/24 18:36
*@description: Git:
 *                  mkdir myproject ---新建目录
 *                  git init        ---初始化仓库
 *                  pwd             ---输出全路径
 *                  ls -lA          ---查看隐藏的文件
 *                  cat .file  ---打开一个文件
 *             设置签名：
 *                  git config      ---设置项目级别
 *                  git config --global ---设置系统级别
 *                  git config user.name dlm ---设置用户名
 *                  git config user.email 956720500@qq.com ---设置用户邮箱
 *             Git命令：
 *                  git status ---查看工作区和暂存区的状态
 *                  git add <filename>  --- 把新建的文件（未追踪）添加到暂存区
 *                  git add .  ---添加所有文件
 *                  git rm --cached <filename>  ---把暂存区的内容恢复到工作空间
 *                  git commit <filename>  ---把暂存区的内容提交到本地仓库
 *                  git log --pretty=oneline ---一行一行的输出log日志
 *                  git reflog
 *                  本地仓库前进和回退：
 *                      git reset --hard [HEAD]
 *
 *                  git diff 比较文件
 *              Git分支：
 *                  git branch  ---查看分支
 *                  git branch dev ---创建分支
 *                  git merge <被合并分支>  ---合并分支(在要合并到的分支上操作)
 *                  hash算法：MD5,SHA-1,CRC32
 *              远程仓库：
 *                  git remote add <origin> https://github.com/dulimao/remote_test.git --- 给远程仓库创建别名
 *                  git push origin master --- 把master推到远程仓库
 *                  git fetch + git merge == git pull //拉取内容
 *              跨团队操作：
 *                  fork -> push -> pull request
 *              SSH登录
 *                   ssh-keygen -t rsa -C dlmazz_global@163.com  --- 生成SSH秘钥
 *                   git remote add origin_ssh git@github.com:dulimao/MyJavaProject.git
 *
 *             Vim:按I，进入编辑模式，输入:wq结束编辑
 *
*/

public class Main {
}
