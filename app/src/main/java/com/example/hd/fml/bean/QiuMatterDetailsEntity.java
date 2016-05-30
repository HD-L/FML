package com.example.hd.fml.bean;

import java.util.List;

/**
 * Created by HD on 2016/5/20.
 */
public class QiuMatterDetailsEntity {

    /**
     * format : image
     * image : app116311979.jpg
     * published_at : 1463010302
     * tag :
     * user : {"avatar_updated_at":1432286013,"uid":25358636,"last_visited_at":1423060499,"created_at":1423060499,"state":"active","last_device":"android_6.0.1","role":"n","login":"选择不由我","id":25358636,"icon":"20150522171333.jpg"}
     * image_size : {"s":[220,296,15918],"m":[500,672,81149]}
     * id : 116311979
     * votes : {"down":-44,"up":598}
     * is_mine : false
     * created_at : 1462984648
     * content : 请呼吁5.12
     * state : publish
     * comments_count : 35
     * allow_comment : true
     * share_count : 14
     */

    private ArticleBean article;
    /**
     * article : {"format":"image","image":"app116311979.jpg","published_at":1463010302,"tag":"","user":{"avatar_updated_at":1432286013,"uid":25358636,"last_visited_at":1423060499,"created_at":1423060499,"state":"active","last_device":"android_6.0.1","role":"n","login":"选择不由我","id":25358636,"icon":"20150522171333.jpg"},"image_size":{"s":[220,296,15918],"m":[500,672,81149]},"id":116311979,"votes":{"down":-44,"up":598},"is_mine":false,"created_at":1462984648,"content":"请呼吁5.12","state":"publish","comments_count":35,"allow_comment":true,"share_count":14}
     * err : 0
     */

    private int err;

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public static class ArticleBean {
        private String format;
        private String image;
        private int published_at;
        private String tag;
        /**
         * avatar_updated_at : 1432286013
         * uid : 25358636
         * last_visited_at : 1423060499
         * created_at : 1423060499
         * state : active
         * last_device : android_6.0.1
         * role : n
         * login : 选择不由我
         * id : 25358636
         * icon : 20150522171333.jpg
         */

        private UserBean user;
        private ImageSizeBean image_size;
        private int id;
        /**
         * down : -44
         * up : 598
         */

        private VotesBean votes;
        private boolean is_mine;
        private int created_at;
        private String content;
        private String state;
        private int comments_count;
        private boolean allow_comment;
        private int share_count;

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getPublished_at() {
            return published_at;
        }

        public void setPublished_at(int published_at) {
            this.published_at = published_at;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public ImageSizeBean getImage_size() {
            return image_size;
        }

        public void setImage_size(ImageSizeBean image_size) {
            this.image_size = image_size;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public VotesBean getVotes() {
            return votes;
        }

        public void setVotes(VotesBean votes) {
            this.votes = votes;
        }

        public boolean isIs_mine() {
            return is_mine;
        }

        public void setIs_mine(boolean is_mine) {
            this.is_mine = is_mine;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public static class UserBean {
            private int avatar_updated_at;
            private int uid;
            private int last_visited_at;
            private int created_at;
            private String state;
            private String last_device;
            private String role;
            private String login;
            private int id;
            private String icon;

            public int getAvatar_updated_at() {
                return avatar_updated_at;
            }

            public void setAvatar_updated_at(int avatar_updated_at) {
                this.avatar_updated_at = avatar_updated_at;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getLast_device() {
                return last_device;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class ImageSizeBean {
            private List<Integer> s;
            private List<Integer> m;

            public List<Integer> getS() {
                return s;
            }

            public void setS(List<Integer> s) {
                this.s = s;
            }

            public List<Integer> getM() {
                return m;
            }

            public void setM(List<Integer> m) {
                this.m = m;
            }
        }

        public static class VotesBean {
            private int down;
            private int up;

            public int getDown() {
                return down;
            }

            public void setDown(int down) {
                this.down = down;
            }

            public int getUp() {
                return up;
            }

            public void setUp(int up) {
                this.up = up;
            }
        }
    }
}
