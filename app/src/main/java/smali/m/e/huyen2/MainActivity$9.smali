.class Lm/e/huyen2/MainActivity$9;
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
    iput-object p1, p0, Lm/e/huyen2/MainActivity$9;->this$0:Lm/e/huyen2/MainActivity;

    .line 1289
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1298
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lm/e/huyen2/MainActivity$9;->this$0:Lm/e/huyen2/MainActivity;

    const-class v2, Lm/e/huyen2/dohuong;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1302
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lm/e/huyen2/MainActivity$9;->this$0:Lm/e/huyen2/MainActivity;

    invoke-virtual {v1, v0}, Lm/e/huyen2/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 1304
    return-void
.end method
