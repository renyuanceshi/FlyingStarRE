.class Lm/e/huyen2/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemSelectedListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/MainActivity;


# direct methods
.method constructor <init>(Lm/e/huyen2/MainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    .line 491
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 24
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 495
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    invoke-static {v2}, Lm/e/huyen2/MainActivity;->access$0(Lm/e/huyen2/MainActivity;)Landroid/widget/Spinner;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lm/e/huyen2/MainActivity;->van:Ljava/lang/String;

    .line 496
    const/16 v22, 0x0

    .local v22, "i":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->data:[Ljava/lang/String;

    array-length v1, v1

    move/from16 v0, v22

    if-lt v0, v1, :cond_0

    .line 501
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->vann:[I

    move-object/from16 v0, p0

    iget-object v3, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget v3, v3, Lm/e/huyen2/MainActivity;->vi1:I

    aget v2, v2, v3

    iput v2, v1, Lm/e/huyen2/MainActivity;->vanz:I

    .line 502
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val:[I

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget v3, v3, Lm/e/huyen2/MainActivity;->vanz:I

    aput v3, v1, v2

    .line 503
    const/16 v23, 0x1

    .local v23, "j":I
    :goto_1
    const/16 v1, 0x9

    move/from16 v0, v23

    if-lt v0, v1, :cond_2

    .line 506
    const/16 v23, 0x0

    :goto_2
    const/16 v1, 0x9

    move/from16 v0, v23

    if-lt v0, v1, :cond_3

    .line 511
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->val:[I

    move-object/from16 v0, p0

    iget-object v3, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v3, v3, Lm/e/huyen2/MainActivity;->b1:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->b2:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v5, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v5, v5, Lm/e/huyen2/MainActivity;->b3:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v6, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v6, v6, Lm/e/huyen2/MainActivity;->b4:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v7, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v7, v7, Lm/e/huyen2/MainActivity;->b5:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v8, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v8, v8, Lm/e/huyen2/MainActivity;->b6:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v9, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v9, v9, Lm/e/huyen2/MainActivity;->b7:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v10, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v10, v10, Lm/e/huyen2/MainActivity;->b8:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v11, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v11, v11, Lm/e/huyen2/MainActivity;->b9:Landroid/widget/TextView;

    invoke-virtual/range {v1 .. v11}, Lm/e/huyen2/MainActivity;->set2([ILandroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V

    .line 512
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget v2, v2, Lm/e/huyen2/MainActivity;->vanz:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget v3, v3, Lm/e/huyen2/MainActivity;->vi2:I

    move-object/from16 v0, p0

    iget-object v4, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->a1:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v5, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v5, v5, Lm/e/huyen2/MainActivity;->a3:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v6, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v6, v6, Lm/e/huyen2/MainActivity;->a5:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v7, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v7, v7, Lm/e/huyen2/MainActivity;->a7:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v8, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v8, v8, Lm/e/huyen2/MainActivity;->a9:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v9, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v9, v9, Lm/e/huyen2/MainActivity;->a11:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v10, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v10, v10, Lm/e/huyen2/MainActivity;->a13:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v11, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v11, v11, Lm/e/huyen2/MainActivity;->a15:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v12, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v12, v12, Lm/e/huyen2/MainActivity;->a17:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v13, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v13, v13, Lm/e/huyen2/MainActivity;->a2:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v14, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v14, v14, Lm/e/huyen2/MainActivity;->a4:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v15, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v15, v15, Lm/e/huyen2/MainActivity;->a6:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v0, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->a8:Landroid/widget/TextView;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->a10:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->a12:Landroid/widget/TextView;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->a14:Landroid/widget/TextView;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->a16:Landroid/widget/TextView;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->a18:Landroid/widget/TextView;

    move-object/from16 v21, v0

    invoke-virtual/range {v1 .. v21}, Lm/e/huyen2/MainActivity;->sehu(IILandroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V

    .line 513
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget v2, v2, Lm/e/huyen2/MainActivity;->th:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget v3, v3, Lm/e/huyen2/MainActivity;->vi1:I

    invoke-virtual {v1, v2, v3}, Lm/e/huyen2/MainActivity;->thanhmon(II)V

    .line 517
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->val:[I

    move-object/from16 v0, p0

    iget-object v3, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v3, v3, Lm/e/huyen2/MainActivity;->b5:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->b9:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v5, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v5, v5, Lm/e/huyen2/MainActivity;->b6:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v6, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v6, v6, Lm/e/huyen2/MainActivity;->b7:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v7, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v7, v7, Lm/e/huyen2/MainActivity;->b2:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v8, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v8, v8, Lm/e/huyen2/MainActivity;->b8:Landroid/widget/TextView;

    .line 518
    move-object/from16 v0, p0

    iget-object v9, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v9, v9, Lm/e/huyen2/MainActivity;->b3:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v10, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v10, v10, Lm/e/huyen2/MainActivity;->b4:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v11, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v11, v11, Lm/e/huyen2/MainActivity;->b1:Landroid/widget/TextView;

    .line 517
    invoke-virtual/range {v1 .. v11}, Lm/e/huyen2/MainActivity;->tomau2([ILandroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V

    .line 601
    return-void

    .line 497
    .end local v23    # "j":I
    :cond_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->van:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->data:[Ljava/lang/String;

    aget-object v2, v2, v22

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 498
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    move/from16 v0, v22

    iput v0, v1, Lm/e/huyen2/MainActivity;->vi1:I

    .line 496
    :cond_1
    add-int/lit8 v22, v22, 0x1

    goto/16 :goto_0

    .line 504
    .restart local v23    # "j":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val:[I

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->val:[I

    const/4 v3, 0x0

    aget v2, v2, v3

    add-int v2, v2, v23

    aput v2, v1, v23

    .line 503
    add-int/lit8 v23, v23, 0x1

    goto/16 :goto_1

    .line 507
    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val:[I

    aget v1, v1, v23

    const/16 v2, 0x9

    if-le v1, v2, :cond_4

    .line 508
    move-object/from16 v0, p0

    iget-object v1, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val:[I

    move-object/from16 v0, p0

    iget-object v2, v0, Lm/e/huyen2/MainActivity$1;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->val:[I

    aget v2, v2, v23

    add-int/lit8 v2, v2, -0x9

    aput v2, v1, v23

    .line 506
    :cond_4
    add-int/lit8 v23, v23, 0x1

    goto/16 :goto_2
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 606
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method
