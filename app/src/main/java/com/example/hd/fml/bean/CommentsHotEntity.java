package com.example.hd.fml.bean;

import java.util.List;

/**
 * Created by HD on 2016/5/24.
 */
public class CommentsHotEntity {

    /**
     * count : 3
     * items : [{"content":"趁早分 不管友没有事 这种家教是众多人所不敢苟同的 以后麻烦事少不了","parent_id":0,"liked":false,"like_count":21,"at_infos":{},"floor":13,"created_at":1463012022,"id":356947721,"user":{"last_visited_at":1455097684,"created_at":1455097684,"last_device":"android_8.4.0","state":"active","role":"n","login":"二帅他哥","id":31168557,"icon":"20160305184527.jpg"}},{"content":"家族.avi","parent_id":0,"liked":false,"like_count":7,"at_infos":{},"floor":8,"created_at":1463010445,"id":356946307,"user":{"last_visited_at":1331781172,"created_at":1331781172,"last_device":"web","state":"bonded","role":"n","login":"立地色魔","id":1032129,"icon":"20160518155829.jpg"}},{"content":"分了吧","parent_id":0,"liked":false,"like_count":5,"at_infos":{},"floor":2,"created_at":1463006511,"id":356943436,"user":{"last_visited_at":1381915152,"created_at":1381915152,"last_device":"ios_2.3.5","state":"active","role":"n","login":"永远不要永远","id":11857253,"icon":"20151116083836.jpg"}}]
     * total : 3
     * page : 1
     * err : 0
     */

    private int count;
    private int total;
    private int page;
    private int err;
    /**
     * content : 趁早分 不管友没有事 这种家教是众多人所不敢苟同的 以后麻烦事少不了
     * parent_id : 0
     * liked : false
     * like_count : 21
     * at_infos : {}
     * floor : 13
     * created_at : 1463012022
     * id : 356947721
     * user : {"last_visited_at":1455097684,"created_at":1455097684,"last_device":"android_8.4.0","state":"active","role":"n","login":"二帅他哥","id":31168557,"icon":"20160305184527.jpg"}
     */

    private List<ItemsBean> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private String content;
        private int parent_id;
        private boolean liked;
        private int like_count;
        private int floor;
        private int created_at;
        private int id;
        /**
         * last_visited_at : 1455097684
         * created_at : 1455097684
         * last_device : android_8.4.0
         * state : active
         * role : n
         * login : 二帅他哥
         * id : 31168557
         * icon : 20160305184527.jpg
         */

        private UserBean user;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            private int last_visited_at;
            private int created_at;
            private String last_device;
            private String state;
            private String role;
            private String login;
            private int id;
            private String icon;

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

            public String getLast_device() {
                return last_device;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
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
    }
}
