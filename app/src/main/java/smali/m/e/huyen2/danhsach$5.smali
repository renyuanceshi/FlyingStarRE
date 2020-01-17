.class Lm/e/huyen2/danhsach$5;
.super Ljava/lang/Object;
.source "danhsach.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/danhsach;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/danhsach;


# direct methods
.method constructor <init>(Lm/e/huyen2/danhsach;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/danhsach$5;->this$0:Lm/e/huyen2/danhsach;

    .line 226
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 229
    iget-object v2, p0, Lm/e/huyen2/danhsach$5;->this$0:Lm/e/huyen2/danhsach;

    iget v2, v2, Lm/e/huyen2/danhsach;->dem:I

    if-nez v2, :cond_0

    .line 230
    iget-object v2, p0, Lm/e/huyen2/danhsach$5;->this$0:Lm/e/huyen2/danhsach;

    .line 231
    const-string v3, "Choose one house"

    const/4 v4, 0x0

    .line 230
    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 232
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 275
    :goto_0
    return-void

    .line 266
    :cond_0
    iget-object v2, p0, Lm/e/huyen2/danhsach$5;->this$0:Lm/e/huyen2/danhsach;

    invoke-virtual {v2}, Lm/e/huyen2/danhsach;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 267
    .local v1, "in23":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 268
    .local v0, "bun3":Landroid/os/Bundle;
    const-string v2, "giocz"

    sget v3, Lm/e/huyen2/danhsach;->ag:I

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 269
    const-string v2, "ghi"

    iget-object v3, p0, Lm/e/huyen2/danhsach$5;->this$0:Lm/e/huyen2/danhsach;

    iget-object v3, v3, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 270
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 272
    iget-object v2, p0, Lm/e/huyen2/danhsach$5;->this$0:Lm/e/huyen2/danhsach;

    const/4 v3, 0x3

    invoke-virtual {v2, v3, v1}, Lm/e/huyen2/danhsach;->setResult(ILandroid/content/Intent;)V

    .line 273
    iget-object v2, p0, Lm/e/huyen2/danhsach$5;->this$0:Lm/e/huyen2/danhsach;

    invoke-virtual {v2}, Lm/e/huyen2/danhsach;->finish()V

    goto :goto_0
.end method
