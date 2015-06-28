package com.scp.roundedbitmapdrawable;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_main);
		initView();
	}

	private void initView() {
		image = (ImageView) findViewById(R.id.image);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.hyomin);
		Drawable rbd = saveBitMap(bitmapToSquare(bitmap));
		image.setImageDrawable(rbd);
	}

	/**
	 * 生成圆角图像
	 * 
	 * @param bitmap
	 *            原图像
	 * @return 圆角图像
	 */
	private Drawable saveBitMap(Bitmap bitmap) {
		/**
		 * 1.加载资源 2.创建RoundedBitmapDrawable 3.设置圆角半径
		 */
		RoundedBitmapDrawable rbd = RoundedBitmapDrawableFactory.create(
				getResources(), bitmap);
		rbd.setCornerRadius(bitmap.getWidth() / 2);// 设置圆角半径为正方形边长的一半
		rbd.setAntiAlias(true);// 设置抗锯齿
		return rbd;
	}

	/**
	 * 从中心生成一个生成正方形
	 * 
	 * @param bitmap
	 *            原图像
	 * @return 正方形图像
	 */
	private Bitmap bitmapToSquare(Bitmap bitmap) {
		if (bitmap.getWidth() >= bitmap.getHeight()) {
			bitmap = Bitmap.createBitmap(bitmap,
					bitmap.getWidth() / 2 - bitmap.getHeight() / 2, 0,
					bitmap.getHeight(), bitmap.getHeight());
		} else {
			bitmap = Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() / 2
					- bitmap.getWidth() / 2, bitmap.getWidth(),
					bitmap.getWidth());
		}

		return bitmap;
	}

}
