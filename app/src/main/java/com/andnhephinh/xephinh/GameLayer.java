package com.andnhephinh.xephinh;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.opengl.CCBitmapFontAtlas;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

/**
 * Created by ANDT on 4/11/2017.
 */

public class GameLayer extends CCLayer {

    public static CGSize screenSize;
    float generalscalefactor = 0.0f;
    private static final int STATUS_LABEL_TAG = 100;
    CCBitmapFontAtlas statusLabel ;

    public GameLayer() {

        screenSize = CCDirector.sharedDirector().winSize();
        generalscalefactor = CCDirector.sharedDirector().winSize().height/500;
        CCSprite background = CCSprite.sprite("background.jpg");
        background.setScale(screenSize.width/background.getContentSize().width); // scale theo ty le man hinh khac nhau
        background.setAnchorPoint(CGPoint.ccp(0f,1f)); // đặt điểm neo là bên trái, góc trên màn hình là (0,1), góc dưới là (0,0)
        background.setPosition(CGPoint.ccp(0,screenSize.height)); // tương tự đặt cho vị trí là (0,screenSize.height)
        addChild(background,-5); // add background to scene với index - 5. Điều này có nghĩa là tất cả các sprite khác được add vào scene với giá trị lớn hơn -5 sẽ được lên top của background

        statusLabel = CCBitmapFontAtlas.bitmapFontAtlas("Tap to start game","bionic.fnt");
        statusLabel.setScale(1.3f*generalscalefactor); // set font chữ to nhỏ
        statusLabel.setAnchorPoint(CGPoint.ccp(0,1)); // anchorpoint mặc định là điểm neo trên cùng bên trái màn hình.
        statusLabel.setPosition(CGPoint.ccp(200*generalscalefactor,screenSize.height - 200 * generalscalefactor)); // cho cái chữ Tap to start game ra giữa màn hình
        addChild(statusLabel,-2,STATUS_LABEL_TAG);// cho điểm z = -2 > -5 của background để nó nằm trên background, STATUS_LABEL_TAG là để đánh dấu, cho số bao nhiêu cũng được

    }

    public static CCScene scene() {
        CCScene scene = CCScene.node();
        CCLayer layer = new GameLayer();
        scene.addChild(layer);
        return scene;
    }
}
