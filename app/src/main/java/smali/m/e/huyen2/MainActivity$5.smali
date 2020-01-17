.class Lm/e/huyen2/MainActivity$5;
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
    iput-object p1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    .line 1128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 15
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
    .line 1133
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    invoke-static {v1}, Lm/e/huyen2/MainActivity;->access$5(Lm/e/huyen2/MainActivity;)Landroid/widget/Spinner;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lm/e/huyen2/MainActivity;->tthang:Ljava/lang/String;

    .line 1134
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->luu:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lm/e/huyen2/MainActivity;->sonam:I

    .line 1135
    const/4 v14, 0x0

    .line 1136
    .local v14, "vino":I
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->data3:[Ljava/lang/String;

    array-length v0, v0

    if-lt v11, v0, :cond_1

    .line 1142
    const/4 v13, 0x0

    .line 1143
    .local v13, "sot":I
    const/4 v11, 0x0

    :goto_1
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->data5:[Ljava/lang/String;

    array-length v0, v0

    if-lt v11, v0, :cond_3

    .line 1148
    const/16 v0, 0xb

    if-ne v13, v0, :cond_0

    .line 1149
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget v0, v0, Lm/e/huyen2/MainActivity;->sonam:I

    const/16 v1, 0x7c0

    if-ne v0, v1, :cond_5

    .line 1150
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    const/16 v1, 0x7bf

    iput v1, v0, Lm/e/huyen2/MainActivity;->sonam:I

    .line 1151
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    const/16 v1, 0x8

    iput v1, v0, Lm/e/huyen2/MainActivity;->vi3:I

    .line 1158
    :cond_0
    :goto_2
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget v0, v0, Lm/e/huyen2/MainActivity;->sonam:I

    rem-int/lit8 v0, v0, 0x3

    if-nez v0, :cond_6

    .line 1159
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val3:[I

    const/4 v1, 0x0

    iget-object v2, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->thang3:[I

    aget v2, v2, v13

    aput v2, v0, v1

    .line 1167
    :goto_3
    const/4 v12, 0x1

    .local v12, "j":I
    :goto_4
    const/16 v0, 0x9

    if-lt v12, v0, :cond_8

    .line 1170
    const/4 v12, 0x0

    :goto_5
    const/16 v0, 0x9

    if-lt v12, v0, :cond_9

    .line 1175
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val2:[I

    const/4 v1, 0x0

    iget-object v2, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget v2, v2, Lm/e/huyen2/MainActivity;->vi3:I

    aput v2, v0, v1

    .line 1177
    const/4 v12, 0x1

    :goto_6
    const/16 v0, 0x9

    if-lt v12, v0, :cond_b

    .line 1180
    const/4 v12, 0x0

    :goto_7
    const/16 v0, 0x9

    if-lt v12, v0, :cond_c

    .line 1185
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->co:Ljava/lang/String;

    const-string v1, "Show"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 1186
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val2:[I

    iget-object v2, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->c1:Landroid/widget/TextView;

    iget-object v3, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v3, v3, Lm/e/huyen2/MainActivity;->c2:Landroid/widget/TextView;

    iget-object v4, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->c3:Landroid/widget/TextView;

    iget-object v5, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v5, v5, Lm/e/huyen2/MainActivity;->c4:Landroid/widget/TextView;

    iget-object v6, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v6, v6, Lm/e/huyen2/MainActivity;->c5:Landroid/widget/TextView;

    iget-object v7, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v7, v7, Lm/e/huyen2/MainActivity;->c6:Landroid/widget/TextView;

    iget-object v8, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v8, v8, Lm/e/huyen2/MainActivity;->c7:Landroid/widget/TextView;

    iget-object v9, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v9, v9, Lm/e/huyen2/MainActivity;->c8:Landroid/widget/TextView;

    iget-object v10, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v10, v10, Lm/e/huyen2/MainActivity;->c9:Landroid/widget/TextView;

    invoke-virtual/range {v0 .. v10}, Lm/e/huyen2/MainActivity;->set22([ILandroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V

    .line 1187
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val3:[I

    iget-object v2, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->d1:Landroid/widget/TextView;

    iget-object v3, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v3, v3, Lm/e/huyen2/MainActivity;->d2:Landroid/widget/TextView;

    iget-object v4, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->d3:Landroid/widget/TextView;

    iget-object v5, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v5, v5, Lm/e/huyen2/MainActivity;->d4:Landroid/widget/TextView;

    iget-object v6, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v6, v6, Lm/e/huyen2/MainActivity;->d5:Landroid/widget/TextView;

    iget-object v7, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v7, v7, Lm/e/huyen2/MainActivity;->d6:Landroid/widget/TextView;

    iget-object v8, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v8, v8, Lm/e/huyen2/MainActivity;->d7:Landroid/widget/TextView;

    iget-object v9, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v9, v9, Lm/e/huyen2/MainActivity;->d8:Landroid/widget/TextView;

    iget-object v10, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v10, v10, Lm/e/huyen2/MainActivity;->d9:Landroid/widget/TextView;

    invoke-virtual/range {v0 .. v10}, Lm/e/huyen2/MainActivity;->set22([ILandroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V

    .line 1225
    :goto_8
    return-void

    .line 1137
    .end local v12    # "j":I
    .end local v13    # "sot":I
    :cond_1
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->luu:Ljava/lang/String;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->data3:[Ljava/lang/String;

    aget-object v1, v1, v11

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1138
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->saol:[I

    aget v1, v1, v11

    iput v1, v0, Lm/e/huyen2/MainActivity;->vi3:I

    .line 1139
    move v14, v11

    .line 1136
    :cond_2
    add-int/lit8 v11, v11, 0x1

    goto/16 :goto_0

    .line 1144
    .restart local v13    # "sot":I
    :cond_3
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->tthang:Ljava/lang/String;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->data5:[Ljava/lang/String;

    aget-object v1, v1, v11

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1145
    move v13, v11

    .line 1143
    :cond_4
    add-int/lit8 v11, v11, 0x1

    goto/16 :goto_1

    .line 1154
    :cond_5
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget v1, v0, Lm/e/huyen2/MainActivity;->sonam:I

    add-int/lit8 v1, v1, -0x1

    iput v1, v0, Lm/e/huyen2/MainActivity;->sonam:I

    .line 1155
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->saol:[I

    add-int/lit8 v2, v14, -0x1

    aget v1, v1, v2

    iput v1, v0, Lm/e/huyen2/MainActivity;->vi3:I

    goto/16 :goto_2

    .line 1161
    :cond_6
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget v0, v0, Lm/e/huyen2/MainActivity;->sonam:I

    rem-int/lit8 v0, v0, 0x3

    const/4 v1, 0x1

    if-ne v0, v1, :cond_7

    .line 1162
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val3:[I

    const/4 v1, 0x0

    iget-object v2, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->thang:[I

    aget v2, v2, v13

    aput v2, v0, v1

    goto/16 :goto_3

    .line 1165
    :cond_7
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val3:[I

    const/4 v1, 0x0

    iget-object v2, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->thang2:[I

    aget v2, v2, v13

    aput v2, v0, v1

    goto/16 :goto_3

    .line 1168
    .restart local v12    # "j":I
    :cond_8
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val3:[I

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val3:[I

    const/4 v2, 0x0

    aget v1, v1, v2

    add-int/2addr v1, v12

    aput v1, v0, v12

    .line 1167
    add-int/lit8 v12, v12, 0x1

    goto/16 :goto_4

    .line 1171
    :cond_9
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val3:[I

    aget v0, v0, v12

    const/16 v1, 0x9

    if-le v0, v1, :cond_a

    .line 1172
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val3:[I

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val3:[I

    aget v1, v1, v12

    add-int/lit8 v1, v1, -0x9

    aput v1, v0, v12

    .line 1170
    :cond_a
    add-int/lit8 v12, v12, 0x1

    goto/16 :goto_5

    .line 1178
    :cond_b
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val2:[I

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val2:[I

    const/4 v2, 0x0

    aget v1, v1, v2

    add-int/2addr v1, v12

    aput v1, v0, v12

    .line 1177
    add-int/lit8 v12, v12, 0x1

    goto/16 :goto_6

    .line 1181
    :cond_c
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val2:[I

    aget v0, v0, v12

    const/16 v1, 0x9

    if-le v0, v1, :cond_d

    .line 1182
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v0, v0, Lm/e/huyen2/MainActivity;->val2:[I

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->val2:[I

    aget v1, v1, v12

    add-int/lit8 v1, v1, -0x9

    aput v1, v0, v12

    .line 1180
    :cond_d
    add-int/lit8 v12, v12, 0x1

    goto/16 :goto_7

    .line 1190
    :cond_e
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->c1:Landroid/widget/TextView;

    iget-object v2, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->c2:Landroid/widget/TextView;

    iget-object v3, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v3, v3, Lm/e/huyen2/MainActivity;->c3:Landroid/widget/TextView;

    iget-object v4, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->c4:Landroid/widget/TextView;

    iget-object v5, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v5, v5, Lm/e/huyen2/MainActivity;->c5:Landroid/widget/TextView;

    iget-object v6, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v6, v6, Lm/e/huyen2/MainActivity;->c6:Landroid/widget/TextView;

    iget-object v7, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v7, v7, Lm/e/huyen2/MainActivity;->c7:Landroid/widget/TextView;

    iget-object v8, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v8, v8, Lm/e/huyen2/MainActivity;->c8:Landroid/widget/TextView;

    iget-object v9, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v9, v9, Lm/e/huyen2/MainActivity;->c9:Landroid/widget/TextView;

    invoke-virtual/range {v0 .. v9}, Lm/e/huyen2/MainActivity;->set33(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V

    .line 1191
    iget-object v0, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v1, v1, Lm/e/huyen2/MainActivity;->d1:Landroid/widget/TextView;

    iget-object v2, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v2, v2, Lm/e/huyen2/MainActivity;->d2:Landroid/widget/TextView;

    iget-object v3, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v3, v3, Lm/e/huyen2/MainActivity;->d3:Landroid/widget/TextView;

    iget-object v4, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v4, v4, Lm/e/huyen2/MainActivity;->d4:Landroid/widget/TextView;

    iget-object v5, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v5, v5, Lm/e/huyen2/MainActivity;->d5:Landroid/widget/TextView;

    iget-object v6, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v6, v6, Lm/e/huyen2/MainActivity;->d6:Landroid/widget/TextView;

    iget-object v7, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v7, v7, Lm/e/huyen2/MainActivity;->d7:Landroid/widget/TextView;

    iget-object v8, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v8, v8, Lm/e/huyen2/MainActivity;->d8:Landroid/widget/TextView;

    iget-object v9, p0, Lm/e/huyen2/MainActivity$5;->this$0:Lm/e/huyen2/MainActivity;

    iget-object v9, v9, Lm/e/huyen2/MainActivity;->d9:Landroid/widget/TextView;

    invoke-virtual/range {v0 .. v9}, Lm/e/huyen2/MainActivity;->set33(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V

    goto/16 :goto_8
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
    .line 1230
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method
