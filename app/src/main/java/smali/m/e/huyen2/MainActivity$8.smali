.class Lm/e/huyen2/MainActivity$8;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/MainActivity;


# direct methods
.method constructor <init>(Lm/e/huyen2/MainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/MainActivity$8;->this$0:Lm/e/huyen2/MainActivity;

    .line 1275
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1281
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$8;->this$0:Lm/e/huyen2/MainActivity;

    invoke-virtual {v1}, Lm/e/huyen2/MainActivity;->getBaseContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lm/e/huyen2/danhsach;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1282
    .local v0, "in2":Landroid/content/Intent;
    iget-object v1, p0, Lm/e/huyen2/MainActivity$8;->this$0:Lm/e/huyen2/MainActivity;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lm/e/huyen2/MainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1286
    return-void
.end method
