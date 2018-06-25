package utils.view.collectionpicker;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ir.talaeii.R;
import org.telegram.messenger.C0906R;

public class CollectionPicker extends LinearLayout {
    public static final int LAYOUT_WIDTH_OFFSET = 3;
    private int mAddIcon;
    private int mCancelIcon;
    private HashMap<String, Object> mCheckedItems;
    private OnItemClickListener mClickListener;
    private LayoutInflater mInflater;
    private boolean mInitialized;
    private int mItemMargin;
    private List<Item> mItems;
    private int mLayoutBackgroundColorNormal;
    private int mLayoutBackgroundColorPressed;
    private int mRadius;
    private LinearLayout mRow;
    private int mTextColor;
    private ViewTreeObserver mViewTreeObserver;
    private int mWidth;
    private int texPaddingBottom;
    private int textPaddingLeft;
    private int textPaddingRight;
    private int textPaddingTop;

    /* renamed from: utils.view.collectionpicker.CollectionPicker$1 */
    class C34991 implements OnGlobalLayoutListener {
        C34991() {
        }

        public void onGlobalLayout() {
            if (!CollectionPicker.this.mInitialized) {
                CollectionPicker.this.mInitialized = true;
                CollectionPicker.this.drawItemView();
            }
        }
    }

    public CollectionPicker(Context context) {
        this(context, null);
    }

    public CollectionPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollectionPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mItems = new ArrayList();
        this.mCheckedItems = new HashMap();
        this.mItemMargin = 10;
        this.textPaddingLeft = 0;
        this.textPaddingRight = 0;
        this.textPaddingTop = 0;
        this.texPaddingBottom = 0;
        this.mAddIcon = 17301555;
        this.mCancelIcon = 17301560;
        this.mLayoutBackgroundColorNormal = ContextCompat.getColor(getContext(), R.color.blue);
        this.mLayoutBackgroundColorPressed = ContextCompat.getColor(getContext(), R.color.red);
        this.mTextColor = ContextCompat.getColor(getContext(), 17170443);
        this.mRadius = 10;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        TypedArray typeArray = context.obtainStyledAttributes(attrs, C0906R.styleable.CollectionPicker);
        this.mItemMargin = (int) typeArray.getDimension(5, (float) Utils.dpToPx(getContext(), this.mItemMargin));
        this.textPaddingLeft = (int) typeArray.getDimension(7, (float) Utils.dpToPx(getContext(), this.textPaddingLeft));
        this.textPaddingRight = (int) typeArray.getDimension(8, (float) Utils.dpToPx(getContext(), this.textPaddingRight));
        this.textPaddingTop = (int) typeArray.getDimension(9, (float) Utils.dpToPx(getContext(), this.textPaddingTop));
        this.texPaddingBottom = (int) typeArray.getDimension(10, (float) Utils.dpToPx(getContext(), this.texPaddingBottom));
        this.mAddIcon = typeArray.getResourceId(3, this.mAddIcon);
        this.mCancelIcon = typeArray.getResourceId(4, this.mCancelIcon);
        this.mLayoutBackgroundColorNormal = typeArray.getColor(1, this.mLayoutBackgroundColorNormal);
        this.mLayoutBackgroundColorPressed = typeArray.getColor(2, this.mLayoutBackgroundColorPressed);
        this.mRadius = (int) typeArray.getDimension(0, (float) this.mRadius);
        this.mTextColor = typeArray.getColor(6, this.mTextColor);
        typeArray.recycle();
        setOrientation(1);
        setGravity(1);
        this.mViewTreeObserver = getViewTreeObserver();
        this.mViewTreeObserver.addOnGlobalLayoutListener(new C34991());
    }

    public int getmTextColor() {
        return this.mTextColor;
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public int getmWidth() {
        return this.mWidth;
    }

    public void setmWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public HashMap<String, Object> getCheckedItems() {
        return this.mCheckedItems;
    }

    public void setCheckedItems(HashMap<String, Object> checkedItems) {
        this.mCheckedItems = checkedItems;
    }

    public void drawItemView() {
        if (this.mInitialized) {
            clearUi();
            float totalPadding = (float) (getPaddingLeft() + getPaddingRight());
            int indexFrontView = 0;
            LayoutParams itemParams = getItemLayoutParams();
            for (int i = 0; i < this.mItems.size(); i++) {
                final Item item = (Item) this.mItems.get(i);
                if (this.mCheckedItems != null && this.mCheckedItems.containsKey(item.id)) {
                    item.isSelected = true;
                }
                final int position = i;
                final View itemLayout = createItemView(item);
                try {
                    itemLayout.setId(Integer.parseInt(item.getId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLayout.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        CollectionPicker.this.animateView(v);
                        item.isSelected = !item.isSelected;
                        if (item.isSelected) {
                            CollectionPicker.this.mCheckedItems.put(item.id, item);
                        } else {
                            CollectionPicker.this.mCheckedItems.remove(item.id);
                        }
                        if (CollectionPicker.this.isJellyBeanAndAbove()) {
                            itemLayout.setBackground(CollectionPicker.this.getSelector(item));
                        } else {
                            itemLayout.setBackgroundDrawable(CollectionPicker.this.getSelector(item));
                        }
                        ((ImageView) itemLayout.findViewById(R.id.item_icon)).setBackgroundResource(CollectionPicker.this.getItemIcon(Boolean.valueOf(item.isSelected)));
                        if (CollectionPicker.this.mClickListener != null) {
                            CollectionPicker.this.mClickListener.onClick(item, position);
                        }
                    }
                });
                TextView itemTextView = (TextView) itemLayout.findViewById(R.id.item_name);
                itemTextView.setText(item.text);
                itemTextView.setPadding(this.textPaddingLeft, this.textPaddingTop, this.textPaddingRight, this.texPaddingBottom);
                itemTextView.setTextColor(getResources().getColor(this.mTextColor));
                float itemWidth = (itemTextView.getPaint().measureText(item.text) + ((float) this.textPaddingLeft)) + ((float) this.textPaddingRight);
                ImageView indicatorView = (ImageView) itemLayout.findViewById(R.id.item_icon);
                indicatorView.setBackgroundResource(getItemIcon(Boolean.valueOf(item.isSelected)));
                indicatorView.setPadding(0, this.textPaddingTop, this.textPaddingRight, this.texPaddingBottom);
                itemWidth += (float) ((Utils.dpToPx(getContext(), 30) + this.textPaddingLeft) + this.textPaddingRight);
                if (((float) this.mWidth) <= (totalPadding + itemWidth) + ((float) Utils.dpToPx(getContext(), 3))) {
                    totalPadding = (float) (getPaddingLeft() + getPaddingRight());
                    indexFrontView = i;
                    addItemView(itemLayout, itemParams, true, i);
                } else {
                    if (i != indexFrontView) {
                        itemParams.leftMargin = this.mItemMargin;
                        totalPadding += (float) this.mItemMargin;
                    }
                    addItemView(itemLayout, itemParams, false, i);
                }
                totalPadding += itemWidth;
            }
        }
    }

    public void drawItemView2(List<Item> newItem) {
        if (this.mInitialized) {
            float totalPadding = (float) (getPaddingLeft() + getPaddingRight());
            int indexFrontView = 0;
            LayoutParams itemParams = getItemLayoutParams();
            for (int i = 0; i < newItem.size(); i++) {
                final Item item = (Item) newItem.get(i);
                if (this.mCheckedItems != null && this.mCheckedItems.containsKey(item.id)) {
                    item.isSelected = true;
                }
                final int position = i;
                final View itemLayout = createItemView(item);
                try {
                    itemLayout.setId(Integer.parseInt(item.getId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLayout.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        CollectionPicker.this.animateView(v);
                        item.isSelected = !item.isSelected;
                        if (item.isSelected) {
                            CollectionPicker.this.mCheckedItems.put(item.id, item);
                        } else {
                            CollectionPicker.this.mCheckedItems.remove(item.id);
                        }
                        if (CollectionPicker.this.isJellyBeanAndAbove()) {
                            itemLayout.setBackground(CollectionPicker.this.getSelector(item));
                        } else {
                            itemLayout.setBackgroundDrawable(CollectionPicker.this.getSelector(item));
                        }
                        ((ImageView) itemLayout.findViewById(R.id.item_icon)).setBackgroundResource(CollectionPicker.this.getItemIcon(Boolean.valueOf(item.isSelected)));
                        if (CollectionPicker.this.mClickListener != null) {
                            CollectionPicker.this.mClickListener.onClick(item, position);
                        }
                    }
                });
                TextView itemTextView = (TextView) itemLayout.findViewById(R.id.item_name);
                itemTextView.setText(item.text);
                itemTextView.setPadding(this.textPaddingLeft, this.textPaddingTop, this.textPaddingRight, this.texPaddingBottom);
                itemTextView.setTextColor(getResources().getColor(this.mTextColor));
                float itemWidth = (itemTextView.getPaint().measureText(item.text) + ((float) this.textPaddingLeft)) + ((float) this.textPaddingRight);
                ImageView indicatorView = (ImageView) itemLayout.findViewById(R.id.item_icon);
                indicatorView.setBackgroundResource(getItemIcon(Boolean.valueOf(item.isSelected)));
                indicatorView.setPadding(0, this.textPaddingTop, this.textPaddingRight, this.texPaddingBottom);
                itemWidth += (float) ((Utils.dpToPx(getContext(), 30) + this.textPaddingLeft) + this.textPaddingRight);
                if (((float) this.mWidth) <= (totalPadding + itemWidth) + ((float) Utils.dpToPx(getContext(), 3))) {
                    totalPadding = (float) (getPaddingLeft() + getPaddingRight());
                    indexFrontView = i;
                    addItemView(itemLayout, itemParams, true, i);
                } else {
                    if (i != indexFrontView) {
                        itemParams.leftMargin = this.mItemMargin;
                        totalPadding += (float) this.mItemMargin;
                    }
                    addItemView(itemLayout, itemParams, false, i);
                }
                totalPadding += itemWidth;
            }
            addItemView(null, itemParams, true, newItem.size());
        }
    }

    private View createItemView(Item item) {
        View view = this.mInflater.inflate(R.layout.collection_picker_item_layout, this, false);
        if (isJellyBeanAndAbove()) {
            view.setBackground(getSelector(item));
        } else {
            view.setBackgroundDrawable(getSelector(item));
        }
        return view;
    }

    private LayoutParams getItemLayoutParams() {
        LayoutParams itemParams = new LayoutParams(-2, -2);
        itemParams.bottomMargin = this.mItemMargin / 2;
        itemParams.topMargin = this.mItemMargin / 2;
        return itemParams;
    }

    private int getItemIcon(Boolean isSelected) {
        return isSelected.booleanValue() ? this.mCancelIcon : this.mAddIcon;
    }

    public void clearUi() {
        removeAllViews();
        this.mRow = null;
    }

    private void addItemView(View itemView, ViewGroup.LayoutParams chipParams, boolean newLine, int position) {
        if (this.mRow == null || newLine) {
            this.mRow = new LinearLayout(getContext());
            this.mRow.setGravity(17);
            this.mRow.setOrientation(0);
            this.mRow.setLayoutParams(new LayoutParams(-1, -2));
            addView(this.mRow);
        }
        if (itemView != null) {
            this.mRow.addView(itemView, chipParams);
            animateItemView(itemView, position);
        }
    }

    private StateListDrawable getSelector(Item item) {
        return item.isSelected ? getSelectorSelected() : getSelectorNormal();
    }

    private StateListDrawable getSelectorNormal() {
        StateListDrawable states = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mLayoutBackgroundColorPressed);
        gradientDrawable.setCornerRadius((float) this.mRadius);
        states.addState(new int[]{16842919}, gradientDrawable);
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mLayoutBackgroundColorNormal);
        gradientDrawable.setCornerRadius((float) this.mRadius);
        states.addState(new int[0], gradientDrawable);
        return states;
    }

    private StateListDrawable getSelectorSelected() {
        StateListDrawable states = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mLayoutBackgroundColorNormal);
        gradientDrawable.setCornerRadius((float) this.mRadius);
        states.addState(new int[]{16842919}, gradientDrawable);
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mLayoutBackgroundColorPressed);
        gradientDrawable.setCornerRadius((float) this.mRadius);
        states.addState(new int[0], gradientDrawable);
        return states;
    }

    public List<Item> getItems() {
        return this.mItems;
    }

    public void setItems(List<Item> items) {
        this.mItems = items;
    }

    public void addItem(Item item) {
        this.mItems.add(item);
    }

    public void clearItems() {
        this.mItems.clear();
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.mClickListener = clickListener;
    }

    private boolean isJellyBeanAndAbove() {
        return VERSION.SDK_INT >= 16;
    }

    private void animateView(final View view) {
        view.setScaleY(1.0f);
        view.setScaleX(1.0f);
        view.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).setStartDelay(0).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
                CollectionPicker.this.reverseAnimation(view);
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        }).start();
    }

    private void reverseAnimation(View view) {
        view.setScaleY(1.2f);
        view.setScaleX(1.2f);
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).setListener(null).start();
    }

    private void animateItemView(View view, int position) {
        long animationDelay = 600 + ((long) (position * 30));
        view.setScaleY(0.0f);
        view.setScaleX(0.0f);
        view.animate().scaleY(1.0f).scaleX(1.0f).setDuration(200).setInterpolator(new DecelerateInterpolator()).setListener(null).setStartDelay(animationDelay).start();
    }
}
