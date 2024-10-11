package com.starrycode.model.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {
        /**
         * id
         */
        private Long id;

        /**
         * 用户名
         */
        private String userName;

        /**
         * 用户昵称
         */
        private String nickName;

        /**
         * 用户头像
         */
        private String userAvatar;

        /**
         * 用户简介
         */
        private String userProfile;

        @Serial
        @TableField(exist = false)
        private static final long serialVersionUID = 1L;
    }
}
